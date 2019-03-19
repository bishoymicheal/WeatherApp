package com.waether.app.features.randomizer

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.usecases.numberIncerementer
import com.example.usecases.reposatires.Ticker

private const val DEFAULT_VALUE = 0
private const val INCREMENT_BY_VALUE = 1

class RandomizerViewModel : ViewModel() {

    val numberLiveData = MutableLiveData<Int>()

    init {
        numberLiveData.value = DEFAULT_VALUE

    }

    override fun onCleared() {
        super.onCleared()
    }
    fun incrementNumber(){
        numberIncerementer(numberLiveData)
    }
}