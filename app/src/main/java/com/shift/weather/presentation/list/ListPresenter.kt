package com.shift.weather.presentation.list

import com.shift.weather.domain.City
import com.shift.weather.domain.GetCitiesUseCase
import com.shift.weather.presentation.BasePresenter

class ListPresenter(private val getCitiesUseCase: GetCitiesUseCase)
    : BasePresenter<ListView>() {

    fun onViewResumed() {
        val citiesList = getCitiesUseCase()

        view?.bindCities(citiesList)
    }

    fun onCitiesClicked(city: City) {
        view?.openDetailsScreen(city.id)
    }


}