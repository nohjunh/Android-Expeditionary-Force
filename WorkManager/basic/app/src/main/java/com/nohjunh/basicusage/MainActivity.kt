package com.nohjunh.basicusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.e("MainActivity Loading")

        val tempData : Data = workDataOf(
            "ap" to "ple",
            "ba" to "nana",
            "peo" to "ple"
        )

        // setInputData() <- WorkManager로 workData 전송
        val workManagerTest = OneTimeWorkRequestBuilder<WorkManagerTest>().setInputData(tempData).build()
        WorkManager.getInstance(this).enqueue(workManagerTest)

        // WorkManager로부터 workData 받아오기
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state.isFinished) {
                    Timber.e("${workInfo.outputData.keyValueMap}")
                }
            })


    }
}
