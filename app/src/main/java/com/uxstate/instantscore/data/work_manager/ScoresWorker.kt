package com.uxstate.instantscore.data.work_manager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class ScoresWorker(
    private val context: Context,
    private val params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        TODO("Not yet implemented")
    }
}