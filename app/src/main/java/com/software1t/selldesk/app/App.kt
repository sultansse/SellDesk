package com.software1t.selldesk.app

import android.app.Application
import com.software1t.selldesk.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initApp()
    }

    private fun initApp() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelModule))
        }
    }
}