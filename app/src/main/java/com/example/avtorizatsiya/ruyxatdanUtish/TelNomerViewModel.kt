package com.example.avtorizatsiya.ruyxatdanUtish

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TelNomerViewModel():ViewModel() {

    val telNomer =MutableLiveData<Any>()

    fun telNomer(msg:String){
        telNomer.setValue(msg)
    }
}