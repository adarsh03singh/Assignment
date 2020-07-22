package com.example.sonetassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sonetassignment.db.MyDatabase
import com.example.sonetassignment.model.countryModelList.CountryModel
import com.example.sonetassignment.model.regionModelList.RegionModel
import com.example.sonetassignment.network.Apis
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainRepository(application: Application) {
    val database: MyDatabase
    val apiServices = Apis()

    init {
        database = MyDatabase.getInstance(
            application.applicationContext
        )
    }

    suspend fun countriesApiNetwork(): Response<List<CountryModel>> {
         val response = apiServices.GetCountriesApi()
        Log.d("hhddh",response.message())

        when (response.isSuccessful) {
            true -> {
                withContext(Dispatchers.IO) {
                    database.countryListDao.delete()
                    database.countryListDao.insert(response.body()!!)
                }
            }
        }

        return response
    }

    suspend fun regionApiNetwork(regionName: String): Response<List<RegionModel>> {
        val response = apiServices.GetRegionApi(regionName)
        Log.d("hhddh",response.message())

        when (response.isSuccessful) {
            true -> {
                withContext(Dispatchers.IO) {
                    database.regionDao.delete()
                    database.regionDao.insert(response.body()!!)
                }
            }
        }

        return response
    }


    fun getCountriesFromDatabase(): LiveData<List<CountryModel>> {
        return database.countryListDao.getAllData()
    }

    fun getRegionFromDatabase(): LiveData<List<RegionModel>> {
        return database.regionDao.getAllDetailData()
    }



}
