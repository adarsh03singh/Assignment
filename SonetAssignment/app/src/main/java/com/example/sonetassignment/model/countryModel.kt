package com.example.sonetassignment.model


import com.google.gson.annotations.SerializedName

data class countryModel(
    val alpha2Code: String?,
    val alpha3Code: String?,
    val altSpellings: List<String?>?,
    val area: Float?,
    val borders: List<String?>?,
    val callingCodes: List<String?>?,
    val capital: String?,
    val cioc: String?,
    val currencies: List<Currency?>?,
    val demonym: String?,
    val flag: String?,
    val gini: Double?,
    val languages: List<Language?>?,
    val latlng: List<Float?>?,
    val name: String?,
    val nativeName: String?,
    val numericCode: String?,
    val population: Int?,
    val region: String?,
    val regionalBlocs: List<RegionalBloc?>?,
    val subregion: String?,
    val timezones: List<String?>?,
    val topLevelDomain: List<String?>?,
    val translations: Translations?
)