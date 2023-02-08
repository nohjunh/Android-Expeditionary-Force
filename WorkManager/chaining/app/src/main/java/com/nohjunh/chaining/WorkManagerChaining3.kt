package com.nohjunh.chaining

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import timber.log.Timber
import java.lang.Thread.sleep

class WorkManagerChaining3 (private val context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        for (i in 1..5) {
            Timber.tag("Chaining3").e("$i")
            sleep(1000)
        }
        return Result.success()
    }

}