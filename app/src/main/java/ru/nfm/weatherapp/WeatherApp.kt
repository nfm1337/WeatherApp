package ru.nfm.weatherapp

import android.app.Application
import ru.nfm.weatherapp.di.ApplicationComponent
import ru.nfm.weatherapp.di.DaggerApplicationComponent

class WeatherApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}