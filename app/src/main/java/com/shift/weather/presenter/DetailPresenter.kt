package com.shift.weather.presenter

import com.shift.weather.models.City
import com.shift.weather.presenter.BasePresenter
import com.shift.weather.repo.CityRepository
import com.shift.weather.view.DetailView
import javax.inject.Inject

class DetailPresenter(
    private val repository: CityRepository,
    private val cityId: Long
) : BasePresenter<DetailView>() {

    override fun onViewAttached() {
        val city = repository.getCity(cityId)

        if (city != null) {
            view?.bindCity(city)
        } else {
            view?.closeScreen()
        }
    }

    fun onSaveButtonClicked(city: City) {
        repository.setCity(city)

        view?.closeScreen()
    }

}