package com.example.sonetassignment.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sonetassignment.model.countryModelList.CountryModel
import com.example.sonetassignment.model.regionModelList.RegionModel
import com.example.sonetassignment.repository.MainRepository
import com.example.sonetassignment.utils.Coroutines


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var repository = MainRepository(application)

    init {

        Coroutines.io {
            repository.countriesApiNetwork()
        }

    }

    fun getAllCountryData(): LiveData<List<CountryModel>> {
        return repository.getCountriesFromDatabase()
    }

    fun getAllRegionData(): LiveData<List<RegionModel>> {
        return repository.getRegionFromDatabase()
    }

    fun heatRegionApi(regData: String) {
        Coroutines.io {

            try {
                repository.regionApiNetwork(regData)
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
    }

    }
