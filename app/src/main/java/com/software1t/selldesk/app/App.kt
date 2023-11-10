package com.software1t.selldesk.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initApp()
    }

    private fun initApp() {
        startKoin {
            androidContext(this@App)
//            modules(modules = appModule)
        }
    }
}