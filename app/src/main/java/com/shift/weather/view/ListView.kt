package com.shift.weather.view

import com.shift.weather.models.City
import com.shift.weather.view.BaseView

interface ListView: BaseView {

    fun bindCities(list: List<City>)

    fun openDetailsScreen(cityId: Long)
}