package com.shift.weather.data

import com.shift.weather.domain.City
import com.shift.weather.domain.CityRepository

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {


    override fun getCities(): List<City> = cityDataSource.getCities()

    override fun getCity(id: Long): City? = cityDataSource.getCity(id)

    }


