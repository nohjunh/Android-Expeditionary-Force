package com.nohjunh.basic.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nohjunh.basic.databinding.ActivityMainBinding
import com.nohjunh.basic.view.fragment.FragTestActivity
import com.nohjunh.basic.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.countView.text = viewModel.countNumber.toString()

        binding.countPlus.setOnClickListener {
            viewModel.plus()
            binding.countView.text = viewModel.getNumber().toString()
        }

        binding.countMinus.setOnClickListener {
            viewModel.minus()
            binding.countView.text = viewModel.getNumber().toString()
        }

        binding.goFragment.setOnClickListener {
            val intent = Intent(this, FragTestActivity::class.java)
            startActivity(intent)
        }

    }
}