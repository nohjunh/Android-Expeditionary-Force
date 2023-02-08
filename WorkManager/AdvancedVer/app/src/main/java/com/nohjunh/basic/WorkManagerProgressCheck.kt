package com.nohjunh.basic

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay

class WorkManagerProgressCheck (private val context : Context, params : WorkerParameters) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        for (i in 1000..1005) {
            val progressState = workDataOf("TimeCheck" to i)
            // Progress 상태를 추가해가며 업데이트
            setProgress(progressState)
            delay(1000)
        }

        return Result.success()
    }

}