package com.example.geeks.domain.usecase

import com.example.geeks.domain.repository.CounterRepository

class IncrementUseCase(private val repository: CounterRepository) {
    operator fun invoke() = repository.increment()
}