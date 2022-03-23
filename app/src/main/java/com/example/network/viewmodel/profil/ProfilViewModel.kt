package com.example.network.viewmodel.profil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.profil.qushish.pasport.PassportMalumotlarSurov
import com.example.network.endtity.profil.qushish.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.endtity.profil.qushish.umumiyJavob.ShaxPassMalumotlarJavob
import com.example.network.repository.profil.ProfilRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class ProfilViewModel(private val profilRepository: ProfilRepository):ViewModel() {

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

}