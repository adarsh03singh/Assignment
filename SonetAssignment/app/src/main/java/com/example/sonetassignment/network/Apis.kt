package com.example.sonetassignment.network

import com.example.sonetassignment.model.countryModel
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://restcountries.eu/"

interface Apis {

    //FOR GETTING COUNTRIES
    @GET("rest/v2/all")
    suspend fun GetCountriesApi(): Response<List<countryModel>>


    companion object {
        val gson = Gson()
        operator fun invoke():  Apis{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Apis::class.java)
        }
    }

}