package com.example.weatherapp.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val OPEN_WEATHER_URL = "https://api.openweathermap.org/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(OPEN_WEATHER_URL)
    .build()

interface WeatherAPIService {
    @GET("/data/2.5/weather")
    fun getWeatherForRegion(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): Call<String>
}

object WeatherApi {
    val retrofitService : WeatherAPIService by lazy {
        retrofit.create(WeatherAPIService::class.java)
    }
}