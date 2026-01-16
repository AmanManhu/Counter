package com.example.geeks.di

import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.geeks.data.datasource.CountDataSource
import com.example.geeks.data.repository.CounterRepositoryImpl
import com.example.geeks.domain.repository.CounterRepository
import com.example.geeks.domain.usecase.DecrementUseCase
import com.example.geeks.domain.usecase.GetCountUseCase
import com.example.geeks.domain.usecase.IncrementUseCase
import com.example.geeks.domain.usecase.ResetUseCase
import com.example.geeks.presentation.ViewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val appModule : List<Module> get() = listOf(dataModule,domainModule,presentationModule)

val dataModule = module {
    single { CountDataSource() }
single<CounterRepository> { CounterRepositoryImpl(dataSource = get()) }
}
val domainModule = module{
    factory{IncrementUseCase(repository = get())}
    factory{ DecrementUseCase(repository = get()) }
    factory{ GetCountUseCase(repository = get()) }
    factory{ ResetUseCase(repository = get()) }
}
val presentationModule = module{
    viewModel{
        MainViewModel(
            incrementUseCase = get(),
            decrementUseCase = get(),
            resetUseCase = get(),
            getCountUseCase = get(),
        )
    }
}