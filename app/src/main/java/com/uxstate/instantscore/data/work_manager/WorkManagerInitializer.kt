package com.uxstate.instantscore.data.work_manager

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import timber.log.Timber

// Heavy weight dependency should be configured here as it increases app startup time
// Typically initializing MobileAds & scheduling work-manager take immense amount of time
@Singleton
class WorkManagerInitializer @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private var isInitialized: Boolean = false
    fun initializeWorkManager() {

        Timber.i("initialization called - value: $isInitialized")
        if (isInitialized) return
        isInitialized = true
        ScoresWorker.schedule(context)
    }
}
