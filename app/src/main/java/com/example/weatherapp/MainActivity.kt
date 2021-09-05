package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.weatherapp.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData

class MainActivity : AppCompatActivity() {

    private val _response = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCurrentTemperature()
    }

    private fun getCurrentTemperature() {
        WeatherApi.retrofitService.getWeatherForRegion(
            "Moscow",
            "metric",
            "810c01341f993c4fa8157d926dad89e7").enqueue( object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                val result: TextView = findViewById(R.id.temperatureNow)
                result.text = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                val result: TextView = findViewById(R.id.temperatureNow)
                result.text = response.body().toString()
            }
        })

    }
}