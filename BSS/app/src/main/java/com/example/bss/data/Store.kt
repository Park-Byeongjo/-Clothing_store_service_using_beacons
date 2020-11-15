package com.example.bss.data

import com.google.firebase.database.Exclude

data class Store (
    @get: Exclude
    var id: String? = null,
    var name: String? = null,
    var style: String? = null,
    var local: String? = null,
    var image: String? = null,
    var open: String? = null,
    var close: String? = null
)
