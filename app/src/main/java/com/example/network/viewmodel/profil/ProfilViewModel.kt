package com.example.network.viewmodel.profil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.entity.profil.biznes.surov.BiznesSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.pasport.PassportMalumotlarSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.umumiyJavob.ShaxPassMalumotlarJavob
import com.example.network.entity.profil.user.UserHaqidaJavob
import com.example.network.repository.profil.ProfilRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class ProfilViewModel(private val profilRepository: ProfilRepository):ViewModel() {




    /*=========User haqida=======================*/


    fun userHaqida(token:String,onResponse:(response:Response<UserHaqidaJavob>)->Unit)
    {
        viewModelScope.launch {
            try{
                onResponse(profilRepository.userHaqida(token))
            }catch (e:Exception){
                D.d("ProfilViewModel userHaqida funi ${e.message}")
            }
        }

    }
    /*====================Profil malumotlarini qushish========================*/
    fun profilMalumotlarQushish(token:String,body:ShaxsiyMalumotlarSurov,onResponse:(response:Response<ShaxPassMalumotlarJavob>)->Unit)
    {
        viewModelScope.launch {
            try{
                onResponse(profilRepository.profilMalumotlarQushish(token,body))
            }catch (e:Exception){
                D.d("ProfilViewModel profilMalumotlarQushish funi ${e.message}")
            }
        }

    }


    /*==================Passport malumotlar qushish =================*/

    fun passportMalumotlarQushish(token: String,body: PassportMalumotlarSurov,onResponse:(response:Response<ShaxPassMalumotlarJavob>) ->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(profilRepository.passportMalumotlarQushish(token,body))
            }catch (e:Exception)
            {
                D.d("ProfilViewModel passportMalumotlarQushish funi ${e.message}")
            }
        }
    }


    /*=================Biznes malumotlani qushish======================*/

    fun biznesMalumotlarQushish(token:String,body:BiznesSurov,onResponse:(response:Response<ShaxPassMalumotlarJavob>)->Unit){
        viewModelScope.launch {
            try {

                onResponse(profilRepository.biznesMalumotlarQushish(token,body))

            }catch (e:Exception)
            {
                D.d("ProfilViewModel biznesMalumotlarQushish funi ${e.message}")
            }
        }
    }

}