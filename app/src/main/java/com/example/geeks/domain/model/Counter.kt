package com.example.geeks.domain.model

data class Counter(
    val count: Int,
    val countIncrement: Int,
    val countDecrement: Int,
    val reset : TypeOfOperation,
)
