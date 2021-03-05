package com.shift.weather.presentation.list

import com.shift.weather.data.CityLocalDataSourceImpl
import com.shift.weather.data.CityRepositoryImpl
import com.shift.weather.domain.GetCitiesUseCase

    object ListPresenterFactory {
        fun getListPresenter(): ListPresenter{
            val cityDataSource = CityLocalDataSourceImpl()
            val cityRepository = CityRepositoryImpl(cityDataSource)
            val getCitiesUseCase = GetCitiesUseCase(cityRepository)
            return ListPresenter(getCitiesUseCase)
        }
    }
