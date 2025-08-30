package com.uxstate.instantscore.data.work_manager

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import timber.log.Timber

@Singleton
class   WorkManagerInitializer @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private var isInitialized: Boolean = false
    fun initializeWorkManager() {
        if (isInitialized) return
        isInitialized = true
        ScoresWorker.schedule(context)
    }
}
