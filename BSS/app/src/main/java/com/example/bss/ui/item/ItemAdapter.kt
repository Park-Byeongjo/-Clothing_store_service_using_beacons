package com.example.bss.ui.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bss.R
import com.example.bss.data.Item
import com.example.bss.data.Store
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewModel>(){

    private var stores = mutableListOf<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewModel (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
    )

    override fun getItemCount() = stores.size

    override fun onBindViewHolder(holder: ItemViewModel, position: Int) {
        holder.view.storeName.text = stores[position].name
        holder.view.storeLocation.text = stores[position].local
    }

    fun setItems(stores: List<Store>){
        this.stores = stores as MutableList<Store>
        notifyDataSetChanged()
    }

    class ItemViewModel(val view: View) : RecyclerView.ViewHolder(view)


}