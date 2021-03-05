package com.shift.weather.data

import com.shift.weather.domain.City

class CityLocalDataSourceImpl: CityDataSource {

    private val cities = mutableListOf(
            City(0, "Tomsk", -10),
            City(1, "Novosibirsk", -13),
            City(2, "Moscow", -3),
            City(3, "Vladivostok", -20),
            City(4, "Ekaterinburg", -10),
            City(5, "Omsk",-12),
            City(6, "Surgut", -18),
            City(7, "Irkutsk", -14),
            City(8, "Kemerovo", -8),
            City(9, "Smolensk", -4)
    )
    override fun getCities(): List<City> = cities

    override fun getCity(id: Long?): City? =cities.firstOrNull { it.id == id }


    }

