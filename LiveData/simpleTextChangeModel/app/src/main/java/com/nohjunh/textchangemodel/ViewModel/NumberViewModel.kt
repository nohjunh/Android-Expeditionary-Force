package com.nohjunh.textchangemodel.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel에서 LiveData에 대한 데이터 관리
class NumberViewModel : ViewModel() {

    // MutableLiveData는 ViewModel에서 관리
    // MutableLiveData는 값이 변경되기에 underscore를 붙임
    private val _curNumber = MutableLiveData<Int>()

    // LiveData
    // ViewModel class 외부에서 MutableLiveData에 access하기 위해서는
    // 값 변경이 불가능한 일반 LiveData 변수의 getter를 통해서
    // MutableLiveData 값에 접근해 가져오게 된다.
    // 리턴타입은 Int LiveData
    val curNumber : LiveData<Int>
        get() = _curNumber

    init {
        // 초기값 설정
        _curNumber.value = 0
    }

    fun calculation(option : String, inputValue : Int) {
        when (option) {
            "+" ->
                _curNumber.value = _curNumber.value?.plus(inputValue)
            "-" ->
                _curNumber.value = _curNumber.value?.minus(inputValue)
        }

    }


}