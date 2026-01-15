package com.example.geeks.domain.usecase

import com.example.geeks.domain.repository.CounterRepository

class ResetUseCase(private val repository: CounterRepository) {
    operator fun invoke() = repository.reset()

}