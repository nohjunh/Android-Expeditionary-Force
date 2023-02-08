package com.nohjunh.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 코루틴 기본
        val workManagerCoroutine = OneTimeWorkRequestBuilder<WorkManagerCoroutine1>().build()
        WorkManager.getInstance(this).enqueue(workManagerCoroutine)
        */


        /* WorkManager Progress 상태 관찰
        val defaultValue = -1
        val workManagerProgressCheck = OneTimeWorkRequestBuilder<WorkManagerProgressCheck>().build()
        WorkManager.getInstance(this).enqueue(workManagerProgressCheck)
        // setProgress를 관찰
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerProgressCheck.id)
            .observe(this, Observer { workInfo ->
                val progressCheck = workInfo.progress
                val getTime = progressCheck.getInt("TimeCheck", defaultValue)
                Timber.tag("progressCheck").e("$getTime")
            })

        */


        /* 주기적 WorkManager 수행
        val workManagerPeriodic = PeriodicWorkRequestBuilder<WorkManagerPeriodic>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workManagerPeriodic)
         */


        /*
        // Manage Tasks
        // 고유 작업은 특정 이름의 작업 인스턴스가 한 번에 하나만 있도록 보장하는 개념
        // WorkManager.enqueueUniqueWork()(일회성 작업)
        // WorkManager.enqueueUniquePeriodicWork()(주기적 작업)
        // existingWorkPolicy - 고유 이름이 있는 작업 체인이 아직 완료되지 않은 경우 WorkManager에 해야 할 작업을 알려주는 enum
        // 고유 작업을 예약할 때는 충돌 발생 시 어떤 작업을 해야 하는지 WorkManager에 알려야 함. 작업을 큐에 추가할 때 enum을 전달하여 알림.

        // 일회성 작업의 경우 충돌을 처리하는 4가지 옵션을 지원하는 ExistingWorkPolicy를 제공
        // REPLACE: 기존 작업을 새 작업으로 대체 (기존 작업을 취소하는 옵션)
        // KEEP: 기존 작업을 유지 (새 작업 무시)
        // APPEND: 새 작업을 기존 작업의 끝에 추가. 새 작업을 기존 작업에 체이닝하여 기존 작업이 완료된 후에 새 작업을 실행하도록 함.

        val keepBtn = findViewById<Button>(R.id.keepBtn)
        keepBtn.setOnClickListener {
            val workManagerManageTasksKeep = OneTimeWorkRequestBuilder<WorkManagerCoroutine1>().build()
            WorkManager.getInstance(this).enqueueUniqueWork("tasks", ExistingWorkPolicy.KEEP, workManagerManageTasksKeep)
        }

        // java.util.concurrent.CancellationException: Task was cancelled. 발생 -> 새로운 work으로 대체
        val replaceBtn = findViewById<Button>(R.id.replaceBtn)
        replaceBtn.setOnClickListener {
            val workManagerManageTasksREPLACE = OneTimeWorkRequestBuilder<WorkManagerCoroutine1>().build()
            WorkManager.getInstance(this).enqueueUniqueWork("tasks", ExistingWorkPolicy.REPLACE, workManagerManageTasksREPLACE)
        }
        */

    }
}