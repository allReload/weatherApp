package com.example.weatherapp.network

import com.squareup.moshi.Json

data class WeatherProperty (
    @field:Json(name = "coord") val coord: List<Coord>,
    @field:Json(name = "weather") val weather: List<Weather>,
    @field:Json(name = "base") val base: String,
    @field:Json(name = "main") val main: List<Main>,
    @field:Json(name = "visibility") val visibility: Int,
    @field:Json(name = "wind") val wind: List<Wind>,
    @field:Json(name = "clouds") val clouds: List<Clouds>,
    @field:Json(name = "dt") val dt: Long,
    @field:Json(name = "sys") val sys: List<Sys>,
    @field:Json(name = "timezone") val timezone: Int,
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "cod") val cod: Int,
)

data class Coord(
    @field:Json(name = "lon") val lon: Int,
    @field:Json(name = "lat") val lat: Int)

data class Weather(
    @field:Json(name = "temp") val weatherList: List<WeatherList>)

data class WeatherList(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "main") val main: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "icon") val icon: String)

data class Main(
    @field:Json(name = "temp") val temp: Int,
    @field:Json(name = "feels_like") val feels_like: Int,
    @field:Json(name = "temp_min") val temp_min: Int,
    @field:Json(name = "temp_max") val temp_max: Int,
    @field:Json(name = "pressure") val pressure: Int,
    @field:Json(name = "humidity") val humidity: Int,
    @field:Json(name = "sea_level") val sea_level: Int,
    @field:Json(name = "grnd_level") val grnd_level: Int)

data class Wind(
    @field:Json(name = "speed") val speed: Int,
    @field:Json(name = "deg") val deg: Int,
    @field:Json(name = "gust") val gust: Int)

data class Clouds(
    @field:Json(name = "all") val all: Int)

data class Sys(
    @field:Json(name = "type") val type: Int,
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "country") val country: String,
    @field:Json(name = "sunrise") val sunrise: Long,
    @field:Json(name = "sunset") val sunset: Long)