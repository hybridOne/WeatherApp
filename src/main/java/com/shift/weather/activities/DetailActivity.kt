package com.shift.weather.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.shift.weather.CityApplication
import com.shift.weather.R
import com.shift.weather.repo.CityRepository

class DetailActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var cityRepository: CityRepository

    private lateinit var cityText: TextView
    private lateinit var degreesText: TextView
    private lateinit var descriptionText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as CityApplication).cityRepository
        setContentView(R.layout.activity_detail)

        initViews()
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val city = cityRepository.getCity(id)

        if (city != null) {
            cityText = findViewById(R.id.nameText)
            degreesText = findViewById(R.id.degreesText)
            descriptionText = findViewById(R.id.descriptionInput)
            saveButton = findViewById(R.id.saveButton)

            cityText.text = getString(R.string.name_format, city.name)
            degreesText.text = getString(R.string.degrees_format, city.degrees)
            descriptionText.setText(city.description ?: getString(R.string.description_absent))

            saveButton.setOnClickListener {
                val editedPerson = city.copy(description = descriptionText.text.toString())
                cityRepository.setCity(editedPerson)
                finish()
            }
        } else {
            finish()
        }
    }
}
