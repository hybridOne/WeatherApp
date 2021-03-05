package com.shift.weather.presentation.detail

import com.shift.weather.domain.GetCityUseCase
import com.shift.weather.presentation.BasePresenter

class DetailPresenter(
        private val getCityUseCase: GetCityUseCase,
        private val id: Long
): BasePresenter<DetailView>() {

    override fun onViewAttached() {
        val city = getCityUseCase(id)
        if (city != null) {
            view?.bindCity(city)
        } else {
            view?.closeScreen()
        }
    }

    fun getSave() {
        view?.closeScreen()
    }
}