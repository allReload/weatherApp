package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weatherapp.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val _response = MutableLiveData<String>()
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init{
        getCurrentTemperature()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    private fun getCurrentTemperature() {
        coroutineScope.launch {
            var getPropertiesDeferred = WeatherApi.retrofitService.getWeatherForRegion(
                "Moscow",
                "metric",
                "810c01341f993c4fa8157d926dad89e7")
            try{
                var listResult = getPropertiesDeferred.await()
                val result: TextView = findViewById(R.id.temperatureNow)
                val res = listResult
            } catch (t:Throwable){
                val result: TextView = findViewById(R.id.temperatureNow)
                result.text = t.message
            }

        }

    }

}