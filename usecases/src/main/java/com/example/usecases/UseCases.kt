package com.example.usecases

import android.arch.lifecycle.MutableLiveData

fun numberIncerementer(liveData: MutableLiveData<Int>,incrementBy:Int=1){
    val oldValue =liveData.value?:0
    liveData.postValue(oldValue+1)
}