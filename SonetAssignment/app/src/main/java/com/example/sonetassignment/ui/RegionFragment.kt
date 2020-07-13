package com.example.sonetassignment.ui


import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetassignment.R
import com.example.sonetassignment.adapter.RegionAdapter
import com.example.sonetassignment.model.countryModel
import com.example.sonetassignment.network.Apis
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_region.*
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import java.lang.reflect.Type


/**
 * A simple [Fragment] subclass.
 */
class RegionFragment : Fragment() {

    var regionName : List<String?>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_region, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runAPi()

        setUpRegionRecyclerView()
    }

    fun setUpRegionRecyclerView()
    {
        val regionRecyclerViewAdapter = RegionAdapter(regionName)
        region_recycler_view.adapter = regionRecyclerViewAdapter
        region_recycler_view.layoutManager = LinearLayoutManager(context,
            RecyclerView.VERTICAL,false)
        region_recycler_view.setHasFixedSize(true)
    }

    fun runAPi(){
        var response : Response<List<countryModel>>? = null

        runBlocking {
            response = Apis().GetCountriesApi()
        }

        if (response != null) {
            if (response!!.isSuccessful) {
                regionName = response!!.body()!!.map { it.region }

            }
        }
    }

}
