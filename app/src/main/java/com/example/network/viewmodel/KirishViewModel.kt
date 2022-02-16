package com.example.network.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.foydalanuvchiBor.FooydalanuvchiniTekshirish
import com.example.network.endtity.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.endtity.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.repository.KirishRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class KirishViewModel(private val kirishRepository: KirishRepository):ViewModel() {




    /*---------------------Foydalanuvchuni ruyxatga olish ----------------------*/
    val ruyxatdanUtish:MutableLiveData<Response<RuyxatdanUtishJavob>> = MutableLiveData()

    fun ruyxatdanUtish(body:RuyxatdanUtishSurov){
        viewModelScope.launch {
            try {
                ruyxatdanUtish.value = kirishRepository.ruyxatdanUtish(body)
            }catch (e:Exception){
                D.d("${e.message}   KirishViewModel ruyxatdanUtish funi")
            }
        }
    }


    /*----------------Telefin raqamni junatish yani foydalanuvchini tekshirish------------------*/
    val telJunatish: MutableLiveData<Response<FooydalanuvchiniTekshirish>> = MutableLiveData()
    fun telJunatish(tel:String)
    {
        viewModelScope.launch {
            try {
                telJunatish.value = kirishRepository.telJunatish(tel)
            }catch (e:Exception)
            {
                D.d("${e.message}   KirishViewModel telJunatish funi")
            }
        }
    }






}