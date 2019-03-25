package com.example.domain

import android.app.Application
import android.arch.lifecycle.MutableLiveData

internal val applicationLiveData = MutableLiveData<Application>()

internal fun<T> MutableLiveData<T>.getApplication(): T {
    return this.value!!
}

object Domin {
    fun integrationWith(application: Application) {
        applicationLiveData.value = application
    }
}