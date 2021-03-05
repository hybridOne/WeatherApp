package com.shift.weather.data

import com.shift.weather.domain.City

interface CityDataSource {
    fun getCities(): List<City>

    fun getCity(id: Long?): City?

}