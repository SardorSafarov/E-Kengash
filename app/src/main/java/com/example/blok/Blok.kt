package com.example.blok

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Blok:ViewModel() {

    private  val blokDb = FirebaseDatabase.getInstance().getReference("BLOK")

    private val _Location = MutableLiveData<List<BlokEntity>>()
    val blok: LiveData<List<BlokEntity>>
        get() = _Location

    fun insertLocation(blok: BlokEntity) {

        blokDb.child("blok").setValue(blok)
            .addOnCompleteListener {
                if(it.isSuccessful)
                {
                    Log.d("sardor", "qo`shildi")
                }else
                {
                    Log.d("sardor", "nimadir bo`ldiii ${it.exception!!.message}")
                }
            }
    }

    fun readLocation(){
        blokDb.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists())
                {
                    val items= mutableListOf<BlokEntity>()
                    p0.children.forEach {
                        val item=it.getValue(BlokEntity::class.java)
                        item?.let { items.add(it) }
                    }
                    _Location.value = items
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }


}