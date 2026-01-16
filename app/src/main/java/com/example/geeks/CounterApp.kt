package com.example.geeks

import android.app.Application
import com.example.geeks.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CounterApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CounterApp)
            androidLogger(Level.DEBUG)
            modules(appModule)
        }
    }
}