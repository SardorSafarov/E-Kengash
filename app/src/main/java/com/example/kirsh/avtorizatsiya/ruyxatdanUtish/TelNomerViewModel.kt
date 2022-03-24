package com.example.kirsh.avtorizatsiya.ruyxatdanUtish

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TelNomerViewModel():ViewModel() {

    val telNomer= MutableLiveData<Any>()
    var telKode = ""
    lateinit var flag:ImageView
    fun telNomer(msg:String){
        telNomer.setValue(msg)
    }
    fun telKode(msg:String)
    {
        telKode = msg
    }
    fun flag(flag: ImageView) {
        this.flag = flag
    }
}