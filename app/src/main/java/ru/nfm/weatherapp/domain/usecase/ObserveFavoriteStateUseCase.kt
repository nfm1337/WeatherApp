package ru.nfm.weatherapp.domain.usecase

import ru.nfm.weatherapp.domain.repository.FavoriteRepository
import javax.inject.Inject

class ObserveFavoriteStateUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {

    operator fun invoke(cityId: Int) = repository.observeIsFavorite(cityId)
}