package com.nohjunh.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nohjunh.basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val array = ArrayList<String>()

        array.add("TEST1")
        array.add("TEST2")
        array.add("TEST3")
        array.add("TEST4")
        array.add("TEST5")

        
        // 어탭터에 데이터 연결
        val adapterInstance = AdapterTest(array)
        // RV어댑터에 데이터를 할당한 어댑터 연결
        binding.recyclerView.adapter = adapterInstance
        // 레이아웃매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}