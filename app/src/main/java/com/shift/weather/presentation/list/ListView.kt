package com.shift.weather.presentation.list

import com.shift.weather.domain.City
import com.shift.weather.presentation.BaseView

interface ListView: BaseView {

    fun bindCities(list: List<City>)

    fun openDetailsScreen(cityId: Long)
}