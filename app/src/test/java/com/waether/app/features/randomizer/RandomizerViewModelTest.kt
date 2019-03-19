package com.waether.app.features.randomizer

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RandomizerViewModelTest{
    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `init Then Update Number Live Data Valute To Zero`(){
        // arrange

        //act
        val viewModel=RandomizerViewModel()
        //assert
        val result=viewModel.numberLiveData.value
        Assert.assertTrue(result==0)
    }

    @Test
    fun `incremeant Number When Number Live Data Is Zero Then Update Number Live Data Value To One`(){
        // arrange
        val viewModel=RandomizerViewModel()
        viewModel.numberLiveData.value?:0
        //act

        viewModel.incrementNumber()
        //assert

        val result=viewModel.numberLiveData.value
        Assert.assertTrue(result==1)
    }


}