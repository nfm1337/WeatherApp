package ru.nfm.weatherapp.domain.usecase

import ru.nfm.weatherapp.domain.entity.City
import ru.nfm.weatherapp.domain.repository.FavoriteRepository
import javax.inject.Inject

class ChangeFavoriteStateUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {

    suspend fun addToFavorite(city: City) = repository.addToFavorite(city)
    suspend fun removeFromFavorite(cityId: Int) = repository.removeFromFavorite(cityId)
}
