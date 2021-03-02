package com.shift.weather.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shift.weather.CityApplication
import com.shift.weather.presenter.ListPresenter
import com.shift.weather.view.ListView
import com.shift.weather.R
import com.shift.weather.adapters.CitiesAdapter
import com.shift.weather.models.City

class ListActivity : AppCompatActivity(), ListView {

    private val presenter by lazy {
        ListPresenter((application as CityApplication).cityRepository)
    }

    private lateinit var citiesList: RecyclerView

    private val adapter by lazy {
        CitiesAdapter(presenter::onCityClicked)
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_list_cities)
            presenter.attachView(this)

            citiesList = findViewById(R.id.citiesList)
            citiesList.adapter = adapter
        }

        override fun onResume(){
            super.onResume()
            presenter.onScreenResumed()
        }

        override fun bindCities(list: List<City>) {
            adapter.cities = list
        }

        override fun openDetailsScreen(cityId: Long) {
            DetailActivity.start(this, cityId)
        }
    }
