package com.nohjunh.basic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nohjunh.basic.adapter.RVadapter
import com.nohjunh.basic.databinding.ActivityMainBinding
import com.nohjunh.basic.model.Post
import com.nohjunh.basic.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPostAll()
        viewModel.getPostNum(5)

        viewModel.apiDataList.observe(this, Observer {
            val adapterInstance = RVadapter(it as Post)
            binding.recyView.adapter = adapterInstance
            binding.recyView.layoutManager = LinearLayoutManager(this)
        })

        viewModel.apiData2.observe(this, Observer {
            binding.textView2.text = it.toString()
        })


    }
}