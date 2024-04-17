package ru.nfm.weatherapp.domain.repository

import ru.nfm.weatherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}