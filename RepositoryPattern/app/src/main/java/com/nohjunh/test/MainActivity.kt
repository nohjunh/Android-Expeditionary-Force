package com.nohjunh.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nohjunh.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainRepositoryImpl = MainRepositoryImpl(100)
    private val factory = MainViewModelFactory(mainRepositoryImpl)
    private val viewModel : MainViewModel by viewModels {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.counterRepository.observe(this, Observer{
            binding.countValue.text = it.toString()
        })

        binding.increaseBtn.setOnClickListener {
            viewModel.increaseCounter()
        }

    }
}