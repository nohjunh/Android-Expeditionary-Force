package com.nohjunh.basic.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nohjunh.basic.R
import com.nohjunh.basic.databinding.ActivityFragBinding
import com.nohjunh.basic.databinding.ActivityMainBinding

class FragActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFragBinding

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Blank1FragBtn.setOnClickListener {
            val transaction1 = manager.beginTransaction()
            val fragment1 = Blank1Fragment()
            transaction1.replace(R.id.fragView, fragment1)
            transaction1.addToBackStack(null)
            transaction1.commit()
        }

        binding.Blank2FragBtn.setOnClickListener {
            val transaction2 = manager.beginTransaction()
            val fragment2 = Blank2Fragment()
            transaction2.replace(R.id.fragView, fragment2)
            transaction2.addToBackStack(null)
            transaction2.commit()
        }


    }
}