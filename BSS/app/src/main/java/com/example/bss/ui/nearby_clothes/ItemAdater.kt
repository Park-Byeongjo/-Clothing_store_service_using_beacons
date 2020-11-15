package com.example.bss.ui.nearby_clothes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bss.R
import com.example.bss.data.Store
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class ItemAdater : RecyclerView.Adapter<ItemAdater.ItemViewHolder>(){
    private var stores = mutableListOf<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_nearby_clothes, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.view.storeName.text = stores[position].name
        holder.view.storeLocation.text = stores[position].local
        Glide.with(holder.view).load(stores[position].image).into(holder.view.storeImage)
    }

    override fun getItemCount() = stores.size

    fun setItems(stores: List<Store>){
        this.stores = stores as MutableList<Store>
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view)

}