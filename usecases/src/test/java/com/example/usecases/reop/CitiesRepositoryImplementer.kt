package com.example.usecases.reop

import com.example.entities.City
import com.example.entities.FavoriteCityId
import com.example.usecases.reposatires.CitiesRepository

import org.junit.Assert.*

open class CitiesRepositoryMock : CitiesRepository
{

    override fun searchCitiesByName(name: String): List<City> {
        return listOf()
    }

    override fun retrieveFavoriteCitiesIds(): List<FavoriteCityId> {
        return listOf()
    }

    override fun retrieveCitiesByIds(citiesIds: List<Long>): List<City> {
        return listOf()
    }

    override fun addFavoriteCityId(favoriteCityId: FavoriteCityId) {
    }

    override fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) {
    }
}