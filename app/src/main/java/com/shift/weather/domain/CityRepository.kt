package com.shift.weather.domain

interface CityRepository {

    fun getCities(): List<City>

    fun getCity(id: Long): City?
}