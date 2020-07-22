package com.example.sonetassignment.model.countryModelList


import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("iso639_1")
    val iso6391: String?,
    @SerializedName("iso639_2")
    val iso6392: String?,
    val name: String?,
    val nativeName: String?
)