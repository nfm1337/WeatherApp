package ru.nfm.weatherapp.presentation.favorite

import kotlinx.coroutines.flow.StateFlow
import ru.nfm.weatherapp.domain.entity.City

interface FavoriteComponent {

    val model: StateFlow<FavoriteStore.State>

    fun onClickSearch()

    fun onClickAddFavorite()

    fun onCityItemClick(city: City)
}