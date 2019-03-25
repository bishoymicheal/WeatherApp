package com.example.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.example.entities.City
import com.example.domain.reposatires.CitiesRepository
import com.example.domain.reposatires.citiesRepository

fun numberIncerementer(liveData: MutableLiveData<Int>,incrementBy:Int=1){
    val oldValue =liveData.value?:0
    liveData.postValue(oldValue+1)
}

//usecase 1 : search
// if is searhcing , then dont trigger action
//city name must not be null
//if all is ok ,trigger search

fun searchCityByName(searchName:String?
    ,searching:MutableLiveData<Boolean>,
                     result: MutableLiveData<List<City>>,
                     repository: CitiesRepository= citiesRepository

                     ){
    searchName?.takeUnless { searching.value?:false }
        ?.also { searching.postValue(true) }
        ?.let {name-> repository.searchCitiesByName(name) }
        ?.also { searching.postValue(false) }
        ?.also { result.postValue(it) }
        ?.also { citiesList -> result.postValue(citiesList) }
}

//usecase 2 : retrive favorite cities ids(longs)
//if favorties not empty, convert them to ids(longs)
// if is searhcing , then dont trigger action

/*fun retrivingCtiesByIds(ids:List<Long>
                        ,retrieving:MutableLiveData<Boolean>
                        ,result: MutableLiveData<List<City>>
                        ,repository: CitiesRepository= citiesRepository){

    return ids.takeUnless { retrieving.value?:false }
        ?.also { retrieving.postValue(true) }
        ?.let { repository.retriveCitiesByIds(it) }
        ?.also { result.postValue(it) }
        ?.also { retrieving.postValue(false) }
}*/

//usecase 3 : retrieve favorite cities by ids
// if is retrieving , then dont trigger action
//if all is ok , trigger action


