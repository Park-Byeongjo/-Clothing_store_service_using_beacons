package com.example.bss.ui.alarm

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bss.data.NODE_STORE
import com.example.bss.data.Store
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AlarmViewModel : ViewModel(){
    private val dbStore = FirebaseDatabase.getInstance().getReference(NODE_STORE)

    private val _stores = MutableLiveData<List<Store>>()
    val store : LiveData<List<Store>>
        get() = _stores

    fun fetchStore(){
        
        dbStore.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException());
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val stores = mutableListOf<Store>()
                    for (storeSnapshot in snapshot.children){
                        val store = storeSnapshot.getValue(Store::class.java)
                        store?.id = storeSnapshot.key
                        store?.let { stores.add(it) }
                    }
                    _stores.value = stores
                }
            }


        })
    }

}