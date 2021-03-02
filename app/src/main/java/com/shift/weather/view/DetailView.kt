package com.shift.weather.view

import com.shift.weather.models.City
import com.shift.weather.view.BaseView

interface DetailView: BaseView {

    fun bindCity(city: City)

    fun closeScreen()
}