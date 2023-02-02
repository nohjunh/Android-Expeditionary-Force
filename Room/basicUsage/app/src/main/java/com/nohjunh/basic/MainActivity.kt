package com.nohjunh.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nohjunh.basic.database.TextDataBase
import com.nohjunh.basic.database.entity.TextEntity
import com.nohjunh.basic.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = TextDataBase.getDatabase(this)

        binding.insertBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                database.textDAO().insert(TextEntity(0, binding.ETview.text.toString()))
                binding.ETview.setText("")
            }
        }

        binding.getBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Timber.tag("데이터보기").e("${database.textDAO().getAllData()}")
            }
        }

        binding.delBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                database.textDAO().delAllData()
            }
        }

    }
}