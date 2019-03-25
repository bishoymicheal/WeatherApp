package com.waether.app.features.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.domain.engine.toMutableLiveData
import com.example.domain.usecases.CitiesResult
import com.example.domain.usecases.SearchCityByNameUseCase
import com.example.entities.City
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import java.util.*

class HomeViewModel(
    val searchProgress: MutableLiveData<Boolean> = false.toMutableLiveData(),
    val citiesResult: CitiesResult = ArrayList<City>().toMutableLiveData(),
    private val searchCityByName: SearchCityByNameUseCase = SearchCityByNameUseCase(
        searchProgress,
        citiesResult
    )
) : ViewModel(){
    fun onSearchButtonClicked(cityName: String?) {
        Observable.fromCallable { searchCityByName(cityName) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun onCleared() {
        super.onCleared()
    }
}