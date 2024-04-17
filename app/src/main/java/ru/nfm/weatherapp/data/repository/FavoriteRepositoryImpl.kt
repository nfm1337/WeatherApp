package ru.nfm.weatherapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nfm.weatherapp.data.local.db.FavoriteCitiesDao
import ru.nfm.weatherapp.data.mapper.toDbModel
import ru.nfm.weatherapp.data.mapper.toEntities
import ru.nfm.weatherapp.domain.entity.City
import ru.nfm.weatherapp.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteCitiesDao: FavoriteCitiesDao
) : FavoriteRepository {

    override val favoriteCities: Flow<List<City>> = favoriteCitiesDao.getFavoriteCities()
        .map { it.toEntities() }

    override fun observeIsFavorite(cityId: Int): Flow<Boolean> = favoriteCitiesDao
        .observeIsFavorite(cityId)

    override suspend fun addToFavorite(city: City) {
        favoriteCitiesDao.addToFavorite(city.toDbModel())
    }

    override suspend fun removeFromFavorite(cityId: Int) {
        favoriteCitiesDao.removeFromFavorite(cityId)
    }
}