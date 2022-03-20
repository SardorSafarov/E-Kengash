package com.example.network.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.netWorkEndtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.netWorkEndtity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.netWorkEndtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.netWorkEndtity.sms.smsKeldi.javob.SmsKeldiJavob
import com.example.network.netWorkEndtity.sms.smsKeldi.surov.SmsKeldiSurov
import com.example.network.netWorkEndtity.sms.telNumberJunatish.javob.SmsJavob
import com.example.network.netWorkEndtity.sms.telNumberJunatish.surov.SmsSurov
import com.example.network.repository.KirishRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class KirishViewModel(private val kirishRepository: KirishRepository):ViewModel() {

    /*=======================Sms keldi================================*/

    fun smsKeldi(body: SmsKeldiSurov,onResponse: (response: Response<SmsKeldiJavob>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(kirishRepository.smsKeldi(body))
            }catch (e:Exception){
                D.d("KirishViewModel smsKeldi funi   ${e.message} ")
            }
        }
    }

    /*==============================Sms========================================*/

    fun smsgaSurovTashlash(body:SmsSurov, onResponse: (response: Response<SmsJavob>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(kirishRepository.sms(body))
            }catch (e:Exception){
                D.d("KirishViewModel sms funi   ${e.message} ")
            }
        }
    }

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
    //argumentiga funkiya qoyilgan interface vasifanisini bajaradi
    fun telJunatish(tel:String,onResponse: (response: Response<FooydalanuvchiniTekshirish>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(kirishRepository.telJunatish(tel))
            }catch (e:Exception)
            {
                D.d("KirishViewModel telJunatish funi  ${e.message}")
            }
        }
    }

}