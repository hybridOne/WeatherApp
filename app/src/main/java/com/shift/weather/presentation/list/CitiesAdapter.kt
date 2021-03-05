package com.shift.weather.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shift.weather.R
import com.shift.weather.domain.City

class CitiesAdapter(private val onClick: (City) -> Unit) : RecyclerView.Adapter<CityHolder>() {

    var cities: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.count()
}

class CityHolder(itemView: View, private val onClick: (City) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val cityText: TextView = itemView.findViewById(R.id.cityText)
    private val descriptionText: TextView = itemView.findViewById(R.id.descriptionText)

    fun bind(city: City) {
        cityText.text = itemView.context.getString(R.string.city_format, city.name, city.degrees)
        itemView.setOnClickListener { onClick(city) }
    }
}