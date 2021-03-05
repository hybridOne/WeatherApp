package com.shift.weather.presentation.detail

import com.shift.weather.domain.City
import com.shift.weather.presentation.BaseView

interface DetailView: BaseView {
    fun bindCity(city: City)

    fun closeScreen()

}