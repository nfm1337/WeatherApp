package ru.nfm.weatherapp.domain.entity

import java.util.Calendar

data class Weather(
    val tempC: Float,
    val conditionText: String,
    val conditionIconUrl: String,
    val date: Calendar
)
