package ru.nfm.weatherapp.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.nfm.weatherapp.data.local.db.FavoriteCitiesDao
import ru.nfm.weatherapp.data.local.db.FavoriteDatabase
import ru.nfm.weatherapp.data.network.api.ApiFactory
import ru.nfm.weatherapp.data.network.api.ApiService
import ru.nfm.weatherapp.data.repository.FavoriteRepositoryImpl
import ru.nfm.weatherapp.data.repository.SearchRepositoryImpl
import ru.nfm.weatherapp.data.repository.WeatherRepositoryImpl
import ru.nfm.weatherapp.domain.repository.FavoriteRepository
import ru.nfm.weatherapp.domain.repository.SearchRepository
import ru.nfm.weatherapp.domain.repository.WeatherRepository

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavoriteDatabase(context: Context): FavoriteDatabase {
            return FavoriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavoriteCitiesDao(database: FavoriteDatabase): FavoriteCitiesDao {
            return database.favoriteCitiesDao()
        }
    }
}