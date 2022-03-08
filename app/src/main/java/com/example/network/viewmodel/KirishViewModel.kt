package com.example.network.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.endtity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.endtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.endtity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.endtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.repository.KirishRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class KirishViewModel(private val kirishRepository: KirishRepository):ViewModel() {

    /*===============Parolni tekshirish========================*/

    val parolniTekshirish:MutableLiveData<Response<ParolniTekshirishJavob>> = MutableLiveData()

    fun parolniTekshirish(body: ParolniTekshirishSurov){
        viewModelScope.launch {
            try {
                parolniTekshirish.value = kirishRepository.parolniTekshirish(body)
            }catch (e:Exception){
                D.d("KirishViewModel parolniTekshirish funi   ${e.message} ")
            }
        }
    }

    /*---------------------Foydalanuvchuni ruyxatga olish ----------------------*/
    val ruyxatdanUtish:MutableLiveData<Response<RuyxatdanUtishJavob>> = MutableLiveData()

    fun ruyxatdanUtish(body: RuyxatdanUtishSurov){
        viewModelScope.launch {
            try {
                ruyxatdanUtish.value = kirishRepository.ruyxatdanUtish(body)
            }catch (e:Exception){
                D.d("KirishViewModel ruyxatdanUtish funi  ${e.message}")
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
                D.d("KirishViewModel telJunatish funi  ${e.message}")
            }
        }
    }

}