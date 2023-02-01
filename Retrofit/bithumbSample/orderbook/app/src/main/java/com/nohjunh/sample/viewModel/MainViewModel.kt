package com.nohjunh.sample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nohjunh.sample.model.CurOrderBookCoin
import com.nohjunh.sample.repository.NetWorkRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val netWorkRepository = NetWorkRepository()

    private var _mutableCoinData = MutableLiveData<List<CurOrderBookCoin>>()
    val coinData : LiveData<List<CurOrderBookCoin>>
        get() = _mutableCoinData

    fun getAllCoinData() = viewModelScope.launch {
        // 1초마다 최신 data로 갱신
        while (true) {
            val curOrderBook = netWorkRepository.getAllCoinData()

            // json -> object 는 fromJson
            // object -> json 은 toJson
            val gson = Gson()
            var coinList = ArrayList<CurOrderBookCoin>()

            try {
                for (coin in curOrderBook.data) {
                    if (coin.key == "timestamp" || coin.key == "payment_currency") {
                        continue
                    } else {
                        val tempjson = gson.toJson(coin.value)
                        // CurOrderBookCoin로 data value 가공
                        val tempgson = gson.fromJson(tempjson, CurOrderBookCoin::class.java)
                        Timber.tag("가공 후").e("$tempgson")

                        coinList.add(tempgson)
                    }
                }
            } catch(e: java.lang.Exception) { Timber.e("${e.toString()}")}

            _mutableCoinData.value = coinList

            delay(1000)
        }
    }

}