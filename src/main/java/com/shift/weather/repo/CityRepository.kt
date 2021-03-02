package com.shift.weather.repo

import com.shift.weather.models.City

class CityRepository() {

    private val cities = mutableListOf(
        City(0, "Tomsk", -10, "Siberia"),
        City(1, "Novosibirsk", -13, "Siberia")
    )

    fun getCities(): List<City> = cities

    fun getCity(id: Long): City? = cities.firstOrNull { it.id == id }

    fun setCity(city: City) {
        val editedCityIndex = cities.indexOfFirst { it.id == city.id }
        if (editedCityIndex >= 0) {
            cities[editedCityIndex] = city

        }
    }


}

