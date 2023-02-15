package com.nohjunh.viewbinding.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nohjunh.viewbinding.Fragment.FragActivity
import com.nohjunh.viewbinding.databinding.ActivityMainBinding


// Activity View Binding
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vbTEST.text = "GOGO"
        binding.GoFragAcitivity.setOnClickListener {
            val intent = Intent(this, FragActivity::class.java)
            startActivity(intent)
        }

    }
}