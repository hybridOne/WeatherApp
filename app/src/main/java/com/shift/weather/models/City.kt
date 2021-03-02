package com.shift.weather.models

data class City (
    val id: Long,
    val name: String,
    val degrees: Int,
    val description: String? = null
)
