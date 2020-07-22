package com.example.sonetassignment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetassignment.R
import com.example.sonetassignment.model.countryModelList.CountryModel
import java.lang.Exception


class CountryAdapter(val list: List<CountryModel>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    var navcontroller: NavController? = null
    var count: Int = 0
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        navcontroller = Navigation.findNavController(p0)
        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.country_name_items, p0, false)

        return ViewHolder(v)
    }

    /*class CustomViewHolder(val view:View):RecyclerView.ViewHolder(view)*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (!list.equals(null)) {
            try {
                val name = list.get(position).name
                val regionName = list.get(position).region
                val latlng = list.get(position).latlng
                holder.countryName.setText(name +" " +latlng!![0].toString()!! + " " + latlng[1]!!.toString() )
                Log.d("ghhghg","hhjhj")
            }catch (e: IndexOutOfBoundsException){
                e.printStackTrace()
            }

        }

        holder.parentLayout.setOnClickListener {
            val bundle = bundleOf("regionName" to list.get(position).region)
            navcontroller!!.navigate(R.id.action_countryNameFragment_to_regionFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        var count = 0
        if (!list.isNullOrEmpty()) {
            count = list.size
        }
        return count
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.countryName)
        val parentLayout: CardView = itemView.findViewById(R.id.countryParentLayout)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}