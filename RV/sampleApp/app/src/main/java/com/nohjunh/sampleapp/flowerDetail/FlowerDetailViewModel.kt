package com.nohjunh.sampleapp.flowerDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nohjunh.sampleapp.data.DataSource
import com.nohjunh.sampleapp.data.Flower

class FlowerDetailViewModel(private val datasource : DataSource) : ViewModel(){

    // id에 일치하는 flower 반환
    fun getFlowerForId(id: Long) : Flower? {
        return datasource.getFlowerForId(id)
    }

    // datasource에서 해당 flower 삭제
    fun removeFlower(flower: Flower) {
        datasource.removeFlower(flower)
    }
}

class FlowerDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowerDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlowerDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}