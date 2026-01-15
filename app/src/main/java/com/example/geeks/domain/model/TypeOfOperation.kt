package com.example.geeks.domain.model

enum class TypeOfOperation(
    val value: Int,
) {
    INCREMENT(1),
    DECREMENT(2),
    RESET(3),
    NONE(0);

    companion object {

        fun toTypeOfOperation(num: Int?): TypeOfOperation{
            return entries.firstOrNull() {it.value == num}?: NONE

        }
    }
}