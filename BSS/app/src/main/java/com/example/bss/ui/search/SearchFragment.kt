package com.example.bss.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bss.MainActivity
import com.example.bss.R
import com.example.bss.ui.setting.SettingFragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.Dispatchers.Main

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {

        val root = inflater.inflate(R.layout.fragment_search, container, false)

        /*
        search_button2.setOnClickListener{
            val intent = Intent(context, SettingFragment::class.java)
            startActivity(intent)
        }
*/
        return root

    }
/*
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_search)



    }*/


}
