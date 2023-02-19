
package com.uxstate.instantscore.di

import android.content.Context
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager
import com.uxstate.instantscore.data.work_manager.ScoresWorker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)

object WorkManagerInitializerModule : Initializer<WorkManager> {

    @Provides
    @Singleton
    override fun create(context: Context): WorkManager {
        ScoresWorker.schedule(context)
        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)

        Timber.i("WorkManager initialized by Hilt")
        return WorkManager.getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}