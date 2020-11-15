package com.example.bss.ui.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bss.R
import kotlinx.android.synthetic.main.fragment_alarm.*

class AlarmFragment :Fragment(){
    private lateinit var viewModel: AlarmViewModel
    private val adapter =  AlarmAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view_alarms.adapter = adapter
        viewModel.fetchStore()

        viewModel.store.observe(viewLifecycleOwner, Observer {
            adapter.setAlarms(it)
        })
    }
}
