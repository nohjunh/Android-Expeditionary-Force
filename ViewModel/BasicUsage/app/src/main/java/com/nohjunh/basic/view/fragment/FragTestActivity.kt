package com.nohjunh.basic.view.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nohjunh.basic.R
import com.nohjunh.basic.databinding.ActivityFragTestBinding
import com.nohjunh.basic.viewModel.MainViewModel

class FragTestActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private lateinit var binding : ActivityFragTestBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = manager.beginTransaction()
        val fragment = ShowFragment()
        transaction.replace(R.id.Container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // 5 값이 fragment에서도 유지되는지 확인
        viewModel.countNumber = 5
    }
}