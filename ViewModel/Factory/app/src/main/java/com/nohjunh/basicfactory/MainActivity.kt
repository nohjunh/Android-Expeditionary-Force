package com.nohjunh.basicfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider


// viewModel을 생성하면서 ACtivity에서 ViewModel로 값을 넘겨줄 땐,
// ViewModelFactory를 이용
class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory(987654321)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }
}