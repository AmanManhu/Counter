package com.example.geeks.data.datasource

import com.example.geeks.data.model.CounterDto

class CountDataSource {
private var counter = 0
private var counterIncrement = 0
private var counterDecrement = 0
private var counterReset = 0
    fun increment(){
        counter++
         counterIncrement++
        counterReset = 1

    }
    fun decrement(){
        counter--
        counterDecrement++
        counterReset  =2


    }
    fun reset(){
        counter = 0
        counterReset = 3

    }
    fun getCount() = CounterDto(
        count = counter,
        countDecrement = counterDecrement,
        countIncrement = counterIncrement,
        reset = counterReset
    )

}