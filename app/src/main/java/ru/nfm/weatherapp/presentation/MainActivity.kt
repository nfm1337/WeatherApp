package ru.nfm.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.nfm.weatherapp.data.network.api.ApiFactory
import ru.nfm.weatherapp.presentation.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiService = ApiFactory.apiService

        CoroutineScope(Dispatchers.Main).launch {
            val currentWeather = apiService.loadCurrentWeather("London")
            val forecast = apiService.loadForecast("London")
            val cities = apiService.searchCity("London")
            Log.d("MainActivity", "Current weather: $currentWeather\nForecast weather: $forecast\nCities: $cities\n")
        }
        setContent {
            WeatherAppTheme {

            }
        }
    }
}