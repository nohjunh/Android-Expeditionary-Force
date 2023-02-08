package com.nohjunh.basicusage

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Thread.sleep

class WorkManagerTest(context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters ) {
    override fun doWork(): Result {
        Timber.tag("Test").e("doWorkManager Start")

        // 테스르를 위해 앱을 종료시킬 시간
        sleep(3000)

        for (item in inputData.keyValueMap) {
            sleep(1000)
            Timber.e("$item")
        }

        // WorkManager를 실행시킨 View로 처리결과 workData 전송
        val finishAlert : Data = workDataOf("finish" to "WorkManagerTest")
        return Result.success(finishAlert)
    }
}