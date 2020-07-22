package com.example.sonetassignment.network

import com.example.sonetassignment.model.countryModelList.CountryModel
import com.example.sonetassignment.model.regionModelList.RegionModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://restcountries.eu/"
private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

val okHttp = OkHttpClient.Builder()
    .addInterceptor(logger)

interface Apis {

    //FOR GETTING COUNTRIES
    @GET("rest/v2/all")
    suspend fun GetCountriesApi(): Response<List<CountryModel>>

    //FOR GETTING REGION

    @GET("rest/v2/region/{region}")
    suspend fun GetRegionApi(
        @Path("region") region: String
        ): Response<List<RegionModel>>


    companion object {
        val gson = Gson()
        operator fun invoke():  Apis{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttp.build())
                .build()
                .create(Apis::class.java)
        }
    }

}