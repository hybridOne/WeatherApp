package com.shift.weather.presentation.detail

import com.shift.weather.data.CityLocalDataSourceImpl
import com.shift.weather.data.CityRepositoryImpl
import com.shift.weather.domain.GetCityUseCase

object DetailPresenterFactory {
    fun getPresenter(id: Long): DetailPresenter {
        val cityDataSource = CityLocalDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepository)
        return DetailPresenter(getCityUseCase, id)

    }
}