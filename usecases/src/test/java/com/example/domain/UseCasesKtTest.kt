package com.example.domain

import android.arch.lifecycle.MutableLiveData
import com.example.entities.City
import com.example.domain.reop.CitiesRepositoryMock
import com.example.domain.usecases.searchCityByName
import org.junit.Assert.*
import org.junit.Test

class UseCasesKtTest{
    //usecase 1 : search
// if is searhcing , then dont trigger action
//city name must not be null
//if all is ok ,trigger search


    @Test
    fun `searchCityByName with valid city name and successful response then update result`(){
        // Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName = "any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()


        // Act
        searchCityByName(cityName, searching, result, repository)

        // Assert
        assertTrue(result.value!!.isNotEmpty())

    }
}
class CitiesRepositoryForSearchCityByName : CitiesRepositoryMock(){

    val result = listOf(City(0L,"","",null),City(0L,"","",null))

    override fun searchCitiesByName(name: String): List<City> {
        return result
    }
}
