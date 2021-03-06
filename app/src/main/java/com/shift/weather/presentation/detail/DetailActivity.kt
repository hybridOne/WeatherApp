package com.shift.weather.presentation.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.shift.weather.R
import com.shift.weather.domain.City


class DetailActivity : AppCompatActivity(), DetailView {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        DetailPresenterFactory.getPresenter(intent.getLongExtra(EXTRA_ID, 0))
    }

    private lateinit var cityText: TextView
    private lateinit var degreesText: TextView

    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()

        presenter.attachView(this)
    }

    private fun initViews() {

        cityText = findViewById(R.id.nameText)
        degreesText = findViewById(R.id.degreesText)
        saveButton = findViewById(R.id.saveButton)

    }

    override fun bindCity(city: City) {

        cityText.text = getString(R.string.name_format, city.name)
        degreesText.text = getString(R.string.degrees_format, city.degrees)

        saveButton.setOnClickListener {
            finish()
        }

    }

    override fun closeScreen() {
        finish()
    }
}
