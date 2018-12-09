package com.memebattle.flexible_control.feature.weather.domain.model

// result generated from /json

data class WeatherResponse(val observations: Observations?)

data class Location(val observation: List<Observation>?, val country: String?, val state: String?, val city: String?, val latitude: Number?, val longitude: Number?, val distance: Number?, val timezone: Number?)

data class Observation(val daylight: String?, val description: String?, val skyInfo: String?, val skyDescription: String?, val temperature: String?, val temperatureDesc: String?, val comfort: String?, val highTemperature: String?, val lowTemperature: String?, val humidity: String?, val dewPoint: String?, val precipitation1H: String?, val precipitation3H: String?, val precipitation6H: String?, val precipitation12H: String?, val precipitation24H: String?, val precipitationDesc: String?, val airInfo: String?, val airDescription: String?, val windSpeed: String?, val windDirection: String?, val windDesc: String?, val windDescShort: String?, val barometerPressure: String?, val barometerTrend: String?, val visibility: String?, val snowCover: String?, val icon: String?, val iconName: String?, val iconLink: String?, val ageMinutes: String?, val activeAlerts: String?, val country: String?, val state: String?, val city: String?, val latitude: Number?, val longitude: Number?, val distance: Number?, val elevation: Number?, val utcTime: String?)

data class Observations(val location: List<Location>?)
