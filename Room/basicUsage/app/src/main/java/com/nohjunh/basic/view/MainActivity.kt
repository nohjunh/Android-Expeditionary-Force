package com.nohjunh.basic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nohjunh.basic.adapter.MainAdapter
import com.nohjunh.basic.database.TextDataBase
import com.nohjunh.basic.databinding.ActivityMainBinding
import com.nohjunh.basic.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val database = TextDataBase.getDatabase(this)

        binding.insertBtn.setOnClickListener {
            viewModel.insertData(binding.ETview.text.toString())
            binding.ETview.setText("")
        }

        binding.getBtn.setOnClickListener {
            viewModel.getAllData()
        }

        viewModel.wordList.observe(this, Observer {
            val mainAdapter = MainAdapter(this, it)
            binding.RVContainer.adapter = mainAdapter
            binding.RVContainer.layoutManager = LinearLayoutManager(this)
        })

        binding.delBtn.setOnClickListener {
            viewModel.deleteData()
        }

    }
}