package com.example.geeks.domain.repository

import com.example.geeks.domain.model.Counter

interface CounterRepository {
    fun increment()
    fun decrement()
    fun reset()
    fun getCount(): Counter
}