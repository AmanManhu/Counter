package com.example.geeks.data.mapper

import com.example.geeks.data.model.CounterDto
import com.example.geeks.domain.model.Counter
import com.example.geeks.domain.model.TypeOfOperation

fun CounterDto.toDomain() = Counter(
    count = count.orDefault(),
    countDecrement = countDecrement.orDefault(),
    countIncrement = countIncrement.orDefault(),
    reset = TypeOfOperation.toTypeOfOperation(reset)

)
fun Int?.orDefault() =  this  ?: 0