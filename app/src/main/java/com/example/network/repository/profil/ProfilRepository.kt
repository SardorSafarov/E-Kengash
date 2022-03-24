package com.example.network.repository.profil

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.endtity.profil.biznes.surov.BiznesSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.pasport.PassportMalumotlarSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.umumiyJavob.ShaxPassMalumotlarJavob
import retrofit2.Response

class ProfilRepository {

    suspend fun profilMalumotlarQushish(token:String,body: ShaxsiyMalumotlarSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.profilMalumotlarQushish(token,body)

    suspend fun passportMalumotlarQushish(token:String,body: PassportMalumotlarSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.passportMalumotlarQushish(token,body)

    suspend fun biznesMalumotlarQushish(token:String,body: BiznesSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.biznesMalumotlarQushish(token,body)
}