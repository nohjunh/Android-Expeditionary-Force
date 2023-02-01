package com.nohjunh.sample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nohjunh.sample.adapter.CoinAdapter
import com.nohjunh.sample.databinding.ActivityMainBinding
import com.nohjunh.sample.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllPriceData()

        viewModel.priceData.observe(this, Observer {
            val coinAdapter = CoinAdapter(this, it)
            binding.coinRVContainer.adapter = coinAdapter
            binding.coinRVContainer.layoutManager = LinearLayoutManager(this)
        })
    }
}