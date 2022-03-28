package com.example.network.api.turarJoy

import com.example.network.entity.takliflarLayfxaklar.javob.TakliflarLayfxaklarJavob
import com.example.network.entity.turarJoy.izlash.TurarJoyIzlashJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TurarJoyApi {

    @GET("/api/v1/hotel")
    suspend fun turarJoyIzlash(@Header("authorization") token: String,
                                    @Query("people")people:String,
                                    @Query("child")child:String,
                                    @Query("city")city:String,
                                    @Query("lang_code")lang_code:String,

    ): Response<TurarJoyIzlashJavob>

}