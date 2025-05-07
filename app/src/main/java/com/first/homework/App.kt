package com.first.homework

import android.app.Application
import com.first.homework.di.AppComponent
import com.first.homework.di.AppModule
import com.first.homework.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }
}
