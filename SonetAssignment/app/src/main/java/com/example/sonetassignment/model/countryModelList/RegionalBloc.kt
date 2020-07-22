package com.example.sonetassignment.model.countryModelList


import com.google.gson.annotations.SerializedName

data class RegionalBloc(
    val acronym: String?,
    val name: String?,
    val otherAcronyms: List<Any?>?,
    val otherNames: List<String?>?
)