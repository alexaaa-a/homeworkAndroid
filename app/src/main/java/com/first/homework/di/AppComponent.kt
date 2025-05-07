package com.first.homework.di

import com.first.homework.di.AppModule
import com.first.homework.ui.weather.WeatherActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: WeatherActivity)
}
