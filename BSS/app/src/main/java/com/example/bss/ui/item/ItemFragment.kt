package com.example.bss.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bss.R
import com.example.bss.data.Store
import kotlinx.android.synthetic.main.fragment_item.*

class ItemFragment: Fragment(){
    private lateinit var viewModel: ItemViewModel
    private val adapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("CreatedView")
        recycler_view_items.adapter = adapter

        viewModel.fetchStore()

        viewModel.store.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
    }

}