package com.example.bss.data

import com.google.firebase.database.Exclude

data class Item(
    @get: Exclude
    var id: String? = null,
    var name: String? = null,
    var size_s: Int? = null,
    var size_m: Int? = null,
    var size_l: Int? = null,
    var size_xl: Int? = null,
    var size_xxl: Int? = null,
    var material : String? = null,
    val image : String? = null
)