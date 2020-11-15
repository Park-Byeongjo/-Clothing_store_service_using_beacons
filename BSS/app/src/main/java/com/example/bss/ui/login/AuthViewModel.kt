package com.example.bss.ui.login

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bss.data.Auth
import com.example.bss.data.NODE_AUTH
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class AuthViewModel : ViewModel(){

    private val dbAuth = FirebaseDatabase.getInstance().getReference(NODE_AUTH)
    private val fAuth = FirebaseAuth.getInstance()
    private val _result = MutableLiveData<String>()
    val result : LiveData<String>
        get() = _result



    fun addAuth(auth: Auth){
        fAuth.createUserWithEmailAndPassword(auth.email.toString(), auth.password.toString())
            .addOnCompleteListener {
                if(!it.isSuccessful) return@addOnCompleteListener
                saveUserToFirebaseDatabase(auth)
            }


    }
    private fun saveUserToFirebaseDatabase(auth: Auth){
        val uid = fAuth.uid?:""
        dbAuth.child(uid).setValue(auth).addOnCompleteListener {
            if(it.isSuccessful){
                _result.value = "Register Success"
            }else{
                _result.value = "Register No Success"
            }

        }
    }

    fun fundAuth(auth: Auth){
        dbAuth.orderByChild("email").equalTo(auth.email.toString()).addChildEventListener(object : ChildEventListener{
            override fun onCancelled(error: DatabaseError) {
                _result.value = "id or password failed"
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

                fAuth.signInWithEmailAndPassword(auth.email.toString(), auth.password.toString()).addOnCompleteListener{
                    _result.value = null
                }

            }


            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }
        })
    }

}