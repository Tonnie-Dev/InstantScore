package com.uxstate.instantscore.data.work_manager

import android.content.Context
import androidx.work.*
import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import java.util.concurrent.TimeUnit

class ScoresWorker(
    private val context: Context,
    private val params: WorkerParameters,
    private val db: ScoresDatabase,
    private val api: ScoresAPI
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        TODO("Not yet implemented")
    }

    companion object {

        private const val SCORES_WORKER_ID = "scores_worker"
        fun schedule(context: Context) {

            val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresStorageNotLow(true)
                    .build()

            val request =
                PeriodicWorkRequestBuilder<ScoresWorker>(
                        6, TimeUnit.HOURS,
                        1, TimeUnit.HOURS
                )
        }
    }
}