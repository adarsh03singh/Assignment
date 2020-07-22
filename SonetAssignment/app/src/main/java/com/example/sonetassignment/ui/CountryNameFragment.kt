package com.example.sonetassignment.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetassignment.adapter.CountryAdapter
import com.example.sonetassignment.R
import com.example.sonetassignment.databinding.FragmentCountryNameBinding
import com.example.sonetassignment.model.countryModelList.CountryModel
import com.example.sonetassignment.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_country_name.*



class CountryNameFragment : Fragment() {


    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_name, container, false)

        val binding: FragmentCountryNameBinding = FragmentCountryNameBinding.bind(view)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.countryViewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.getAllCountryData().observe(viewLifecycleOwner, Observer<List<CountryModel>> { countryData ->

            try{

                setUpCountryRecyclerView(countryData)
            }catch (e: Exception){
                e.printStackTrace()
            }
        })

        return view
    }

    fun setUpCountryRecyclerView(conyData: List<CountryModel>)
    {
        val projectRecyclerViewAdapter = CountryAdapter(conyData)
        country_recycler_view.adapter = projectRecyclerViewAdapter
        country_recycler_view.layoutManager = LinearLayoutManager(context,
            RecyclerView.VERTICAL,false)
        country_recycler_view.setHasFixedSize(true)
    }


}
