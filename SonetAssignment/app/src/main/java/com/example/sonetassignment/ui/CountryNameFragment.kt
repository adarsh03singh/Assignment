package com.example.sonetassignment.ui


import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetassignment.adapter.CountryAdapter
import com.example.sonetassignment.R
import com.example.sonetassignment.model.countryModel
import com.example.sonetassignment.network.Apis
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_country_name.*
import kotlinx.coroutines.runBlocking
import retrofit2.Response


class CountryNameFragment : Fragment() {

//    val PRIVATE_MODE = 0
//    val PREF_NAME = "regToken"
//    val sharedPrefer: SharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE)

    var countryName : List<String?>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runAPi()

        setUpCountryRecyclerView()

    }

    fun setUpCountryRecyclerView()
    {
        val projectRecyclerViewAdapter = CountryAdapter(countryName)
        country_recycler_view.adapter = projectRecyclerViewAdapter
        country_recycler_view.layoutManager = LinearLayoutManager(context,
            RecyclerView.VERTICAL,false)
        country_recycler_view.setHasFixedSize(true)
    }

    fun runAPi(){
        var response : Response<List<countryModel>>? = null

        runBlocking {
            response = Apis().GetCountriesApi()
        }

        if (response != null) {
            if (response!!.isSuccessful) {
                countryName = response!!.body()!!.map { it.name }
                val regionName = response!!.body()!!.map { it.region }

            }
        }
    }
}
