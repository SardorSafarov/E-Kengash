package com.example.network.repository.profil

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.profil.biznes.surov.BiznesSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.pasport.PassportMalumotlarSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.umumiyJavob.ShaxPassMalumotlarJavob
import com.example.network.entity.profil.user.UserHaqidaJavob
import retrofit2.Response

class ProfilRepository {

    suspend fun userHaqida(token:String):Response<UserHaqidaJavob> = RetrofitBuilder().profil.userHaqida(token)

    suspend fun profilMalumotlarQushish(token:String,body: ShaxsiyMalumotlarSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.profilMalumotlarQushish(token,body)

    suspend fun passportMalumotlarQushish(token:String,body: PassportMalumotlarSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.passportMalumotlarQushish(token,body)

    suspend fun biznesMalumotlarQushish(token:String,body: BiznesSurov):Response<ShaxPassMalumotlarJavob> = RetrofitBuilder().profil.biznesMalumotlarQushish(token,body)
}