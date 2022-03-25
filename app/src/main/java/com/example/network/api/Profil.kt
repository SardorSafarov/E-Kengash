package com.example.network.api

import com.example.network.entity.profil.biznes.surov.BiznesSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.pasport.PassportMalumotlarSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.entity.profil.shaxsniTasdiqlash.umumiyJavob.ShaxPassMalumotlarJavob
import com.example.network.entity.profil.user.UserHaqidaJavob
import com.example.network.entity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import retrofit2.Response
import retrofit2.http.*

interface Profil {



    @GET("/api/v1/me")
    suspend fun userHaqida(@Header("authorization") token: String): Response<UserHaqidaJavob>


    @POST("/api/v1/me/data")
    suspend fun profilMalumotlarQushish(@Header("authorization") token:String,@Body body: ShaxsiyMalumotlarSurov ):Response<ShaxPassMalumotlarJavob>

    @POST("/api/v1/me/passport")
    suspend fun passportMalumotlarQushish(@Header("authorization") token:String,@Body body: PassportMalumotlarSurov ):Response<ShaxPassMalumotlarJavob>


    @POST("/api/v1/me/org")
    suspend fun biznesMalumotlarQushish(@Header("authorization") token:String,@Body body: BiznesSurov ):Response<ShaxPassMalumotlarJavob>


}