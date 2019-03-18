package com.waether.app.features.randomizer

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.usecases.randomNumberGenerator
import com.example.usecases.reposatires.Ticker

private const val DEFAULT_VALUE = 0
private const val INCREMENT_BY_VALUE = 1

class RandomizerViewModel : ViewModel() {
    private val ticker = initializerTicker()
    val numberLiveData = MutableLiveData<Int>()
    private fun initializerTicker() = Ticker({
        val oldValue = numberLiveData.value ?: DEFAULT_VALUE
        numberLiveData.postValue(randomNumberGenerator().toInt())
    })

    init {
        numberLiveData.value = DEFAULT_VALUE
        ticker.start()

    }

    override fun onCleared() {
        super.onCleared()
        ticker.cancel()
    }
}