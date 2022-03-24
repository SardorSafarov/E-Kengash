package com.example.network.api

import com.example.network.endtity.profil.biznes.surov.BiznesSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.pasport.PassportMalumotlarSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.umumiyJavob.ShaxPassMalumotlarJavob
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface Profil {

    @POST("/api/v1/me/data")
    suspend fun profilMalumotlarQushish(@Header("authorization") token:String,@Body body: ShaxsiyMalumotlarSurov ):Response<ShaxPassMalumotlarJavob>

    @POST("/api/v1/me/passport")
    suspend fun passportMalumotlarQushish(@Header("authorization") token:String,@Body body: PassportMalumotlarSurov ):Response<ShaxPassMalumotlarJavob>


    @POST("/api/v1/me/org")
    suspend fun biznesMalumotlarQushish(@Header("authorization") token:String,@Body body: BiznesSurov ):Response<ShaxPassMalumotlarJavob>


}