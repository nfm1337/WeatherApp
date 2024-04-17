package ru.nfm.weatherapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.nfm.weatherapp.domain.entity.City

interface FavoriteRepository {

    val favoriteCities: Flow<City>

    fun observeIsFavorite(cityId: Int): Flow<Boolean>

    suspend fun addToFavorite(city: City)

    suspend fun removeFromFavorite(cityId: Int)
}