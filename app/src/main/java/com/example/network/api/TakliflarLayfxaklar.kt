package com.example.network.api

import com.example.network.endtity.info.javob.InfoJavob
import com.example.network.endtity.takliflarLayfxaklar.javob.TakliflarLayfxaklarJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TakliflarLayfxaklar {

    @GET("/api/v1/data/stories")
    suspend fun takliflarLayfxaklar(@Header("authorization") token: String, @Query("page")query:String): Response<TakliflarLayfxaklarJavob>

}