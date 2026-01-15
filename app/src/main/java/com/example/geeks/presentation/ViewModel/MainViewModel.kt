package com.example.geeks.presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geeks.domain.model.Counter
import com.example.geeks.domain.usecase.DecrementUseCase
import com.example.geeks.domain.usecase.GetCountUseCase
import com.example.geeks.domain.usecase.IncrementUseCase
import com.example.geeks.domain.usecase.ResetUseCase
import kotlinx.coroutines.sync.Mutex

class MainViewModel(
    private val getCountUseCase: GetCountUseCase,
    private val incrementUseCase: IncrementUseCase,
    private val decrementUseCase: DecrementUseCase,
    private val resetUseCase: ResetUseCase,
    ): ViewModel() {
    private val _counterData = MutableLiveData<Counter>()
    val counterData = _counterData

     fun updateCounter(){
        _counterData.value = getCountUseCase()
    }
    fun increment(){
        incrementUseCase()
        updateCounter()
    }
    fun decrement() {
        decrementUseCase()
        updateCounter()
    }

    fun reset() {
        resetUseCase()
        updateCounter()
    }
}