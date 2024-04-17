package ru.nfm.weatherapp.data.mapper

import ru.nfm.weatherapp.data.network.dto.CityDto
import ru.nfm.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }