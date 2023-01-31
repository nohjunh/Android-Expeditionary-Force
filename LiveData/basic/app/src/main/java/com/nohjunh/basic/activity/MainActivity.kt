package com.nohjunh.basic.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nohjunh.basic.MainViewModel
import com.nohjunh.basic.databinding.ActivityMainBinding
import com.nohjunh.basic.fragment.FragActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plusBtn.setOnClickListener {
            viewModel.plusLiveDataNumber()
        }

        binding.minusBtn.setOnClickListener {
            viewModel.minusLiveDataNumber()
        }

        viewModel.changedNumber.observe(this, Observer {
            binding.numberView.text = it.toString()
        })


        binding.goFrag.setOnClickListener {
            val intent = Intent(this, FragActivity::class.java)
            startActivity(intent)
        }

    }
}