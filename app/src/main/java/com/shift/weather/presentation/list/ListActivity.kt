package com.shift.weather.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shift.weather.R
import com.shift.weather.domain.City
import com.shift.weather.presentation.detail.DetailActivity

class ListActivity : AppCompatActivity(), ListView {

    private val presenter by lazy {
        ListPresenterFactory.getListPresenter()
    }

    private lateinit var citiesList: RecyclerView
    private val adapter = CitiesAdapter {
        presenter.onCitiesClicked(it)
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
            presenter.onViewResumed()
        }

        override fun bindCities(list: List<City>) {
            adapter.cities = list
        }

        override fun openDetailsScreen(cityId: Long) {
            DetailActivity.start(this, cityId)
        }
    }
