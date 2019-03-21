package com.example.usecases.reposatires

import com.example.entities.City
import com.example.entities.FavoriteCityId
import com.example.usecases.database.WeatherDatabase
import com.example.usecases.database.weatherDatabase

val citiesRepository by lazy {CitiesRepository()}

class CitiesRepository(private val database: WeatherDatabase=weatherDatabase) {
    fun searchCitiesByName(name: String): List<City> =database.citiesDao.queryCitiesByName(name)

    fun retriveFavoriteCitiesIds(): List<FavoriteCityId> =database.favoritesDao.queryAll()

    fun retriveCitiesByIds(citiesIds: List<Long>): List<City> =database.citiesDao.queryCitiesByIds(citiesIds)

    fun addFavoriteCityId(favoriteCityId: FavoriteCityId)=database.favoritesDao.addFavoritCityById(favoriteCityId)

    fun removeFavoriteCityId(favoriteCityId: FavoriteCityId)= database.favoritesDao.removeFavoritCityById(favoriteCityId)

}