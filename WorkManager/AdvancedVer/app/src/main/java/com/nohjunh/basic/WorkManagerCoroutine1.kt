package com.nohjunh.basic

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Thread.sleep

// https://medium.com/androiddevelopers/workmanager-meets-kotlin-b9ad02f7405e

class WorkManagerCoroutine1 (private val context : Context, params : WorkerParameters) : CoroutineWorker(context, params){
    override suspend fun doWork(): Result {

        withContext(Dispatchers.IO) {
            test1()
            test2()
        }

        return Result.success()
    }
    private suspend fun test1() {
        Timber.tag("Coroutine WM").e("test1 Function{1}")
        delay(2000)
        Timber.tag("Coroutine WM").e("test1 Function{2}")
    }

    private suspend fun test2() {
        Timber.tag("Coroutine WM").e("test2 Function{1}")
        delay(2000)
        Timber.tag("Coroutine WM").e("test2 Function{2}")
    }
}