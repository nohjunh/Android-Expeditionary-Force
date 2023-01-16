package com.nohjunh.textchangemodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nohjunh.textchangemodel.ViewModel.NumberViewModel
import com.nohjunh.textchangemodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :  ActivityMainBinding

    private val viewModel : NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // viewModel의 LiveData에 access
        // Mutable이 아니라 일반LiveData에 접근하는거!!
        // observe() 메소드를 통해 LiveData를 관찰하겠다.
        // 관찰하는 주체는 this
        viewModel.curNumber.observe(this, Observer {
            binding.DisplayNumber.text = it.toString()
        })


        // ViewModel의 LiveData 값 변경
        binding.PlusButton.setOnClickListener {
            val inputValue = binding.inputNumber.text.toString().toInt()
            viewModel.calculation("+", inputValue)
        }

        binding.MinusButton.setOnClickListener {
            val inputValue = binding.inputNumber.text.toString().toInt()
            viewModel.calculation("-", inputValue)
        }
    }

}