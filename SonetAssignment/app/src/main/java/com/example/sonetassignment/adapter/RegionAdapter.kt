package com.example.sonetassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetassignment.R


class RegionAdapter(val list: List<String?>?) : RecyclerView.Adapter<RegionAdapter.ViewHolder>() {

    var navcontroller: NavController? = null

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        navcontroller = Navigation.findNavController(p0)
        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.country_name_items, p0, false)

        return ViewHolder(v)
    }

    /*class CustomViewHolder(val view:View):RecyclerView.ViewHolder(view)*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (list != null) {
            holder.regionName.setText(list.get(position))
        }

//    holder.parentLayout.setOnClickListener {
//        navcontroller!!.navigate(R.id.action_countryNameFragment_to_regionFragment)
//    }
    }

    override fun getItemCount(): Int {
        var count = 0
        if (!list.isNullOrEmpty()) {
            count = list.size
        }
        return count
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val regionName: TextView = itemView.findViewById(R.id.countryName)
        val parentLayout: CardView = itemView.findViewById(R.id.countryParentLayout)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}