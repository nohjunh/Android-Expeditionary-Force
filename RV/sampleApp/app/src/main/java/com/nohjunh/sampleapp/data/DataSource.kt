package com.nohjunh.sampleapp.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialFlowerList = flowerList(resources)
    private val flowersLiveData = MutableLiveData(initialFlowerList)

    /* LiveData 설명
     https://velog.io/@haero_kim/Android-LiveData-알고-사용하기
     https://leveloper.tistory.com/179
    */
    // LiveData에 flower 추가하고 posts value
    fun addFlower(flower: Flower) {
        // LiveData의 value가 변경되면 Observer Callback이 호출되어 값이 변경
        val currentList = flowersLiveData.value
        // LiveData의 값 변경 함수 setValue(), postValue()
        // postValue()는 setValue()와는 달리 백그라운드에서 값을 변경 -> 백그라운드 쓰레드에서 동작하다가 메인 쓰레드에 값을 post 하는 방식 동작
        if (currentList == null) {
            flowersLiveData.postValue(listOf(flower))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, flower) // List의 0번 째 index에 flower 객체 삽입
            flowersLiveData.postValue(updatedList)
        }
    }

    // LiveData에서 해당 flower 삭제하고 posts value
    fun removeFlower(flower: Flower) {
        val currentList = flowersLiveData.value ?: return
        val updatedList = currentList.toMutableList()
        updatedList.remove(flower)
        flowersLiveData.postValue(updatedList)
    }

    // id가 맞으면 해당 Flower 객체 반환
    fun getFlowerForId(id: Long) : Flower? {
        flowersLiveData.value?.let { flowers ->
            return flowers.firstOrNull{ it.id == id }
        }
        return null
    }

    // flowerList 반환
    fun getFlowerList() : LiveData<List<Flower>> {
        return flowersLiveData
    }

    /* Returns a random flower asset for flowers that are added. */
    fun getRandomFlowerImageAsset(): Int? {
        val randomNumber = (initialFlowerList.indices).random()
        return initialFlowerList[randomNumber].image
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }



}