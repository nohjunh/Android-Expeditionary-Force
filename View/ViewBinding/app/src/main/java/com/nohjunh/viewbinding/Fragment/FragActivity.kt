package com.nohjunh.viewbinding.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nohjunh.viewbinding.R

class FragActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)

        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragmentKT = VbFragment()
        fragmentTransaction.add(R.id.fragmentContainer, fragmentKT)
        fragmentTransaction.commit()

    }
}