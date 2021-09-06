package com.example.weatherapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val OPEN_WEATHER_URL = "https://api.openweathermap.org/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(OPEN_WEATHER_URL)
    .build()

interface WeatherAPIService {
    @GET("/data/2.5/weather")
    fun getWeatherForRegion(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): Deferred<List<WeatherProperty>>
}

object WeatherApi {
    val retrofitService : WeatherAPIService by lazy {
        retrofit.create(WeatherAPIService::class.java)
    }
}