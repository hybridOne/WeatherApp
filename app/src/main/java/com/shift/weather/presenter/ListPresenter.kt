package com.shift.weather.presenter

import com.shift.weather.models.City
import com.shift.weather.presenter.BasePresenter
import com.shift.weather.repo.CityRepository
import com.shift.weather.view.ListView

class ListPresenter(private val repository: CityRepository): BasePresenter<ListView>() {

    fun onScreenResumed() {
        val cities = repository.getCities()

        view?.bindCities(cities)
    }

    fun onCityClicked(city: City) {
        view?.openDetailsScreen(city.id)
    }

}