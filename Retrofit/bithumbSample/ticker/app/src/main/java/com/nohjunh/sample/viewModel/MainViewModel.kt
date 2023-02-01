package com.nohjunh.sample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nohjunh.sample.model.CurrentCoin
import com.nohjunh.sample.model.CurrentPrice
import com.nohjunh.sample.repository.NetWorkRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber


class MainViewModel : ViewModel() {

    private val netWorkRepository = NetWorkRepository()

    private var _mutablePriceData = MutableLiveData<List<CurrentCoin>>()
    val priceData : LiveData<List<CurrentCoin>>
        get() = _mutablePriceData

    fun getAllPriceData() = viewModelScope.launch {
        // 1초마다 최신 data로 갱신
        while (true) {
            val currentStatusData = netWorkRepository.getAllPriceData()
            // json -> object 는 fromJson
            // object -> json 은 toJson
            val gson = Gson()

            var coinList= ArrayList<CurrentCoin>()
            try {
                for (coin in currentStatusData.data) {
                    Timber.tag("가공 전").e("${currentStatusData.data.get(coin.key)}")
                    val tempjson= gson.toJson(currentStatusData.data.get(coin.key))
                    // CurrentPrice로 data value 가공
                    val tempgson= gson.fromJson(tempjson, CurrentPrice::class.java)
                    Timber.tag("가공 후").e("$tempgson")
                    // CurrentCoin으로 coinName과 CurrentPrice 가공
                    val currentCoin = CurrentCoin(coin.key, tempgson)
                    Timber.tag("CoinData").e("$currentCoin")

                    coinList.add(currentCoin)
                }
            } catch(e: java.lang.Exception) { Timber.e("${e.toString()}") }

            _mutablePriceData.value = coinList

            delay(1000)
        }

    }


}