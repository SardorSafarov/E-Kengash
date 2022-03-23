package com.example.network.repository.profil

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.endtity.profil.qushish.pasport.PassportMalumotlarSurov
import com.example.network.endtity.profil.qushish.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.endtity.profil.qushish.umumiyJavob.ShaxPassMalumotlarJavob
import retrofit2.Response

class ProfilRepository {

    suspend fun profilMalumotlarQushish(token:String,body: ShaxsiyMalumotlarSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.profilMalumotlarQushish(token,body)

    suspend fun passportMalumotlarQushish(token:String,body: PassportMalumotlarSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.passportMalumotlarQushish(token,body)
}