package com.waether.app.features.randomizer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.waether.app.R
import kotlinx.android.synthetic.main.activity_randomizer.*

class Randomizer: AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)
        val viewModel= ViewModelProviders.of(this).get(RandomizerViewModel::class.java)

        viewModel.numberLiveData.observe(this,
            Observer { random_number_textView.text=it.toString() })
        incerement_button.setOnClickListener {
            viewModel.incrementNumber()
        }
    }
}