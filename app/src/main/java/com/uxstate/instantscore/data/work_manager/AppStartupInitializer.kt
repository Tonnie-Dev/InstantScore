package com.uxstate.instantscore.data.work_manager

import android.content.Context
import androidx.startup.Initializer

class AppStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        ScoresWorker.schedule(context.applicationContext)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> =
        listOf(androidx.work.WorkManagerInitializer::class.java)


}