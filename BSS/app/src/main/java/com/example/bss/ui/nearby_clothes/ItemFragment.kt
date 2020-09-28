package com.example.bss.ui.nearby_clothes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bss.MyItemRecyclerViewAdapter
import com.example.bss.R
import com.example.bss.dummy.DummyContent
import com.example.bss.ui.notifications.NotificationsViewModel
/**
 * A fragment representing a list of Items.
 */

class ItemFragment : Fragment() {
    private lateinit var itemFragmentViewModel: ItemFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nearby_clothes_list, container, false)



        return view
    }


}