package com.software1t.selldesk.app

import android.app.Application
import com.software1t.selldesk.di.appModule
import com.software1t.selldesk.di.viewModelModule
import com.software1t.selldesk.domain.MyRepository
import org.koin.android.ext.android.inject
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
            modules(appModule)
        }
    }
}