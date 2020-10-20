package com.example.bss.ui.nearby_clothes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bss.R
import kotlinx.android.synthetic.main.fragment_nearby_clothes.*

/**
 * A fragment representing a list of Items.
 */

class ItemFragment : Fragment() {
    private lateinit var viewModel: ItemViewModel
    private val adater = ItemAdater()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =  ViewModelProvider(this).get(ItemViewModel::class.java)
        return inflater.inflate(R.layout.fragment_nearby_clothes, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.fetchStore()

        recycler_view_nearby_clothes.adapter = adater

        viewModel.store.observe(viewLifecycleOwner, Observer {
            adater.setItems(it)
        })
    }
}