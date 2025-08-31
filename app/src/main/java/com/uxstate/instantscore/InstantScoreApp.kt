package com.uxstate.instantscore

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.uxstate.instantscore.data.work_manager.ScoresWorker
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import timber.log.Timber

@HiltAndroidApp
/*class InstantScoreApp : Application(), Configuration.Provider {*/
class InstantScoreApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        ScoresWorker.schedule(this)
    }


}

   /* @Inject
    lateinit var workerFactory: HiltWorkerFactory

  override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
                .setWorkerFactory(workerFactory)
                .build()
    }*/


//https://medium.com/@santimattius/workmanager-with-hilt-and-app-startup-80b34062e144