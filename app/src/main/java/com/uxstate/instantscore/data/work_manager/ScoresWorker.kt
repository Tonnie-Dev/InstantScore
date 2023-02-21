package com.uxstate.instantscore.data.work_manager

import android.content.Context
import androidx.room.withTransaction
import androidx.work.*
import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.data.remote.mappers.toEntity
import com.uxstate.instantscore.utils.SCORES_WORKER_ERROR_KEY
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.io.IOException
import java.util.concurrent.TimeUnit
import retrofit2.HttpException
import timber.log.Timber

class ScoresWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val params: WorkerParameters,
    private val db: ScoresDatabase,
    private val api: ScoresAPI
) : CoroutineWorker(context, params) {

    private val dao = db.dao
    override suspend fun doWork(): Result {
        Timber.i("DoWork Called")
        return try {
            val response = api.getFixturesByDate()

            db.withTransaction {
            }
            dao.clearFixtures()
            dao.insertFixtures(response.response.map { it.toEntity() })
            Result.success()
        } catch (e: IOException) {
            Timber.i("WorKError - IO")
            Result.failure(workDataOf(SCORES_WORKER_ERROR_KEY to e.localizedMessage))
        } catch (e: HttpException) {
            Timber.i("WorKError - Http")
            Result.failure(workDataOf(SCORES_WORKER_ERROR_KEY to e.localizedMessage))
        } catch (e: Exception) {
            Timber.i("WorKError - Exception")
            Result.failure(workDataOf(SCORES_WORKER_ERROR_KEY to e.localizedMessage))
        }
    }

    companion object {

        private const val SCORES_WORKER_ID = "scores_worker"
        fun schedule(context: Context) {
            Timber.i("companion Obj schedule() called")
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                //  .setRequiresStorageNotLow(true)
                .build()

            val request = PeriodicWorkRequestBuilder<ScoresWorker>(
                15, TimeUnit.MINUTES, 5, TimeUnit.MINUTES
            ).setConstraints(constraints)
                .build()

            WorkManager.getInstance(context)
                .enqueueUniquePeriodicWork(
                    SCORES_WORKER_ID, ExistingPeriodicWorkPolicy.UPDATE, request
                )
        }
    }
}