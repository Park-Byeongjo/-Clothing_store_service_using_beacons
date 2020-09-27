package com.example.bss.ui.nearby_clothes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bss.MyItemRecyclerViewAdapter
import com.example.bss.R
import com.example.bss.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragmentViewModel : Fragment() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Item Fragment"
    }
    val text: LiveData<String> = _text
}