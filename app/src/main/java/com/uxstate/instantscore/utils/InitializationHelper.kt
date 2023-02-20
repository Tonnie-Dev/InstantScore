package com.uxstate.instantscore.utils

import android.content.Context
import com.uxstate.instantscore.data.work_manager.ScoresWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

// Heavy weight dependency should be configured here as it increases app startup time
// Typically initializing MobileAds & scheduling work-manager take immense amount of time
@Singleton
class InitializationHelper @Inject constructor(
    @ApplicationContext private val context: Context,

) {

    private var isInitialized: Boolean = false

    fun initializeDependencies() {
        if (isInitialized) return

        isInitialized = true



        ScoresWorker.schedule(context)

    }
}
