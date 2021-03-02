package com.shift.weather.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shift.weather.CityApplication
import com.shift.weather.R
import com.shift.weather.adapters.CitiesAdapter
import com.shift.weather.models.City
import com.shift.weather.repo.CityRepository

class ListActivity : AppCompatActivity() {

    private lateinit var cityRepository: CityRepository

    private lateinit var citiesList: RecyclerView

    private val adapter = CitiesAdapter {
        DetailActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as CityApplication).cityRepository
        setContentView(R.layout.activity_list_cities)

        citiesList = findViewById(R.id.citiesList)
        citiesList.adapter = adapter
    }


    override fun onResume() {
        super.onResume()
        adapter.cities = cityRepository.getCities()
    }
}