package com.nohjunh.basic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nohjunh.basic.R
import com.nohjunh.basic.adapter.PlantAdapter
import com.nohjunh.basic.databinding.ActivityMainBinding
import com.nohjunh.basic.model.PlantList
import com.nohjunh.basic.viewModel.MainViewModel

// API server
// https://raw.githubusercontent.com/10y01noo/googlecodelabs-kotlin-coroutines/main/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllData()

        viewModel.apiResult.observe(this, Observer {
            val plantAdapter = PlantAdapter(this, it as PlantList)
            binding.RVContainer.adapter = plantAdapter
            binding.RVContainer.layoutManager = LinearLayoutManager(this)
        })

    }

}