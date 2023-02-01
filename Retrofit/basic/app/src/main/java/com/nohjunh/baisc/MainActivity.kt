package com.nohjunh.baisc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nohjunh.baisc.api.Apis
import com.nohjunh.baisc.api.RetrofitInstance
import com.nohjunh.baisc.databinding.ActivityMainBinding
import com.nohjunh.baisc.model.Post
import com.nohjunh.baisc.model.PostItem
import com.nohjunh.baisc.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPost()
        viewModel.getPostNum(5)

        viewModel.apiData1.observe(this, Observer {
            binding.text1.text = it.toString()
        })

        viewModel.apiData2.observe(this, Observer {
            binding.text2.text = it.toString()
        })

    }
}