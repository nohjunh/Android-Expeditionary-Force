package com.nohjunh.chaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerTest1 = OneTimeWorkRequestBuilder<WorkManagerChaining1>().build()
        val workManagerTest2 = OneTimeWorkRequestBuilder<WorkManagerChaining2>().build()
        val workManagerTest3 = OneTimeWorkRequestBuilder<WorkManagerChaining3>().build()

        // WorkManager Chaining one by one
        WorkManager.getInstance(this)
            .beginWith(workManagerTest1)
            .then(workManagerTest2)
            .then(workManagerTest3)
            .enqueue()

        /*
        // WorkManager Chaining Tgt
        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerTest1, workManagerTest2))
            .then(workManagerTest3)
            .enqueue()
        */

    }

}