package com.example.bss.ui.alarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bss.R
import com.example.bss.data.Store
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class AlarmAdapter :RecyclerView.Adapter<AlarmAdapter.AlarmViewModel>(){
    private var stores = mutableListOf<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlarmViewModel (
        LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_alarm, parent, false)
    )

    override fun getItemCount() = stores.size

    override fun onBindViewHolder(holder: AlarmViewModel, position: Int) {
        holder.view.storeName.text = stores[position].name
        holder.view.storeLocation.text = stores[position].local
        Glide.with(holder.view).load(stores[position].image).into(holder.view.storeImage)
    }

    fun setAlarms(stores: List<Store>){
        this.stores = stores as MutableList<Store>
        notifyDataSetChanged()
    }

    class AlarmViewModel(val view: View): RecyclerView.ViewHolder(view)

}