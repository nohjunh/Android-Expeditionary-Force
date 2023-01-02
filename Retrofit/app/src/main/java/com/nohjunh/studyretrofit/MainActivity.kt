package com.nohjunh.studyretrofit

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.studyretrofit.network.model.CurrentPriceDTO
import com.nohjunh.studyretrofit.repository.CurrentPriceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var listAdapter: ListAdapter
    val datas = mutableListOf<CurrentPriceDTO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentPriceRepository = CurrentPriceRepository()

        currentPriceRepository.getCurrentList().getCurrentValues().enqueue(object :
            Callback<CurrentPriceDTO> {
            override fun onResponse(
                call: Call<CurrentPriceDTO>,
                response: Response<CurrentPriceDTO>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        var test= findViewById<TextView>(R.id.textTest)
                        test.text= body.data.toString()
                    }
                }
            }

            override fun onFailure(call: Call<CurrentPriceDTO>, t: Throwable) {
                t.message?.let { Log.d("this is error", it) }
            }
        })
    }
}
