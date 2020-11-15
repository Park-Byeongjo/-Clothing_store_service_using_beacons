package com.example.bss.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Notifications Fragment"
    }
    val text: LiveData<String> = _text
}