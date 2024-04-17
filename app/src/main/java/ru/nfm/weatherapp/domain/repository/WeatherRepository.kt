package ru.nfm.weatherapp.domain.repository

import ru.nfm.weatherapp.domain.entity.Forecast
import ru.nfm.weatherapp.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}