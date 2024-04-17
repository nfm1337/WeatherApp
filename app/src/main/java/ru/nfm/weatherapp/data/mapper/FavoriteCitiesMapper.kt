package ru.nfm.weatherapp.data.mapper

import ru.nfm.weatherapp.data.local.model.CityDbModel
import ru.nfm.weatherapp.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntity(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }