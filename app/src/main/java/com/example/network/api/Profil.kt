package com.example.network.api

import com.example.network.endtity.profil.qushish.pasport.PassportMalumotlarSurov
import com.example.network.endtity.profil.qushish.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.endtity.profil.qushish.umumiyJavob.ShaxPassMalumotlarJavob
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface Profil {

    @POST("/api/v1/me/passport")
    suspend fun profilMalumotlarQushish(@Header("authorization") token:String,@Body body: ShaxsiyMalumotlarSurov ):Response<ShaxPassMalumotlarJavob>

    @POST("/api/v1/me/passport")
    suspend fun passportMalumotlarQushish(@Header("authorization") token:String,@Body body: PassportMalumotlarSurov ):Response<ShaxPassMalumotlarJavob>

}