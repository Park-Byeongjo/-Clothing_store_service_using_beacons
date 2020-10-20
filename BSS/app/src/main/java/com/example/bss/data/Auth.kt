package com.example.bss.data

import com.google.firebase.database.Exclude

data class Auth(
    @get:Exclude
    val id:String? = null,
    var email: String? = null,
    var name: String? = null,
    var password: String? = null
)