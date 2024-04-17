package ru.nfm.weatherapp.data.repository

import ru.nfm.weatherapp.data.mapper.toEntities
import ru.nfm.weatherapp.data.network.api.ApiService
import ru.nfm.weatherapp.domain.entity.City
import ru.nfm.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}