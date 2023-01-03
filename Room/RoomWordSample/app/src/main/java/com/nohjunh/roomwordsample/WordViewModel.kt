package com.nohjunh.roomwordsample

import androidx.lifecycle.*
import kotlinx.coroutines.launch

// WordRepository를 매개변수로 가져오고 ViewModel을 확장하는 WordViewModel 클래스 정의
class WordViewModel(private val repository: WordRepository) : ViewModel() {

    // Words들의 List(data type)를 캐시하는 LiveData 멤버 변수인 allWords 정의
    // Repository의 allWords Flow를 통해 Livedata 초기화 후,
    // asLiveData()를 통해 Flow를 LiveData로 변환
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    // Repository의 insert() 메소드를 호출하는 wrapper insert() 메소드 생성
    // -> insert()가 UI에서 캡슐화
    // launch를 통해 새 코루틴을 빌딩하고 suspend function인 insert 호출
    // viewModel에는 viewModelScope라는 lifecycle 기반 코루틴 scope가 존재
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

// viewModel을 만들고, 구체적으로는 WordViewModel을 만드는데 필요한 WordRepository를
// 매개변수로 가져오는 viewModelProvider.Factory 구현
// configuration 변경에도 유지되고 만약, Activity가 다시 생성된다 하더라도,
// 항상 WordViewModel 클래스의 올바른 인스턴스를 가져오게 됨.
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}