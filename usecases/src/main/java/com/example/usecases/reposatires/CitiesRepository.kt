package com.example.usecases.reposatires

import com.example.entities.City
import com.example.entities.FavoriteCityId
import com.example.usecases.database.WeatherDatabase
import com.example.usecases.database.weatherDatabase

val citiesRepository: CitiesRepository by lazy { CitiesRepositoryImplementer() }

interface CitiesRepository {

    fun searchCitiesByName(name: String): List<City>

    fun retrieveFavoriteCitiesIds(): List<FavoriteCityId>

    fun retrieveCitiesByIds(citiesIds: List<Long>): List<City>

    fun addFavoriteCityId(favoriteCityId: FavoriteCityId): Unit

    fun removeFavoriteCityId(favoriteCityId: FavoriteCityId): Unit
}

class CitiesRepositoryImplementer(private val database: WeatherDatabase = weatherDatabase) : CitiesRepository {

    override fun searchCitiesByName(name: String) = database.citiesDao.queryCitiesByName(name)

    override fun retrieveFavoriteCitiesIds() = database.favoritesDao.queryAll()

    override fun retrieveCitiesByIds(citiesIds: List<Long>) = database.citiesDao.queryCitiesByIds(citiesIds)

    override fun addFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritesDao.addFavoritCityById(favoriteCityId)

    override fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritesDao.removeFavoritCityById(favoriteCityId)

}