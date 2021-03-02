package com.shift.weather

import android.app.Application
import com.shift.weather.repo.CityRepository

class CityApplication : Application() {

    lateinit var cityRepository: CityRepository

    override fun onCreate() {
        super.onCreate()
        cityRepository = CityRepository()
    }
}