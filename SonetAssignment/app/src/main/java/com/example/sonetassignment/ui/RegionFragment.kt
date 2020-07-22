package com.example.sonetassignment.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetassignment.R
import com.example.sonetassignment.adapter.RegionAdapter
import com.example.sonetassignment.databinding.FragmentRegionBinding
import com.example.sonetassignment.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_region.*
import com.example.sonetassignment.model.regionModelList.RegionModel


/**
 * A simple [Fragment] subclass.
 */
class RegionFragment : Fragment() {


    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_region, container, false)

        val binding: FragmentRegionBinding = FragmentRegionBinding.bind(view)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.regionViewmodel = viewModel
        binding.lifecycleOwner = this

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val regionname = arguments?.getString("regionName")
        Log.d("hgshhg", regionname)

        if(regionname != null){

                viewModel.heatRegionApi(regionname)

        }

        viewModel.getAllRegionData().observe(viewLifecycleOwner,
            androidx.lifecycle.Observer<List<RegionModel>> { regionData ->

                try {

                    setUpRegionRecyclerView(regionData)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            })

    }

    fun setUpRegionRecyclerView(regiondata : List<RegionModel>)
    {
        val regionRecyclerViewAdapter = RegionAdapter(regiondata)
        region_recycler_view.adapter = regionRecyclerViewAdapter
        region_recycler_view.layoutManager = LinearLayoutManager(context,
            RecyclerView.VERTICAL,false)
        region_recycler_view.setHasFixedSize(true)
    }


}
