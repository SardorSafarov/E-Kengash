package com.example.avtorizatsiya.ruyxatdan_utish

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TelNomerViewModel():ViewModel() {

    val telNomer =MutableLiveData<Any>()

    fun telNomer(msg:String){
        telNomer.setValue(msg)
    }
}