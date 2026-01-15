package com.example.geeks.data.repository

import com.example.geeks.data.datasource.CountDataSource
import com.example.geeks.data.mapper.toDomain
import com.example.geeks.domain.model.Counter
import com.example.geeks.domain.repository.CounterRepository

class CounterRepositoryImpl(private val dataSource: CountDataSource): CounterRepository {
    override fun increment() {dataSource.increment()}
    override fun decrement() { dataSource.decrement() }
    override fun reset() { dataSource.reset()}
    override fun getCount(): Counter { return dataSource.getCount().toDomain() }
}