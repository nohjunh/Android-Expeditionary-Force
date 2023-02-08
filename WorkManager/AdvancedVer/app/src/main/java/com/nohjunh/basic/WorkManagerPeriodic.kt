package com.nohjunh.basic

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import timber.log.Timber

class WorkManagerPeriodic (private val context : Context, params : WorkerParameters) : CoroutineWorker(context, params) {

    var count = 0
    override suspend fun doWork(): Result {

        Timber.tag("WM Periodic").e("$count")
        count++
        return Result.success()
    }

}