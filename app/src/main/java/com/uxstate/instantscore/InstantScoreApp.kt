package com.uxstate.instantscore

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import timber.log.Timber

@HiltAndroidApp
class InstantScoreApp : Application(), Configuration.Provider {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

  override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
                .setWorkerFactory(workerFactory)
                .build()
    }


//https://medium.com/@santimattius/workmanager-with-hilt-and-app-startup-80b34062e144