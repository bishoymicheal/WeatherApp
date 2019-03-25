package com.waether.app

import android.app.Application
import com.example.domain.Domin

class WeatherApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        Domin.integrationWith(this)

    }
}