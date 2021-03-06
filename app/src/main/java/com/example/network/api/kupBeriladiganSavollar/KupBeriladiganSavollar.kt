package com.example.network.api.kupBeriladiganSavollar

import com.example.network.entity.bildirshnoma.BildirishNomaJavob
import com.example.network.entity.info.javob.InfoJavob
import com.example.network.entity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KupBeriladiganSavollar {

    @GET("/api/v1/info/faq")
    suspend fun kupBeriladiganSavollar(@Header("authorization") token: String, ): Response<KupBeriladiganSavollarJavob>

    @GET("/api/v1/info/info")
    suspend fun info(@Header("authorization") token: String,@Query("lang")lang:String): Response<InfoJavob>

    @GET("/api/v1/data/notification_news")
    suspend fun bildirishnoma(@Header("authorization") token: String): Response<BildirishNomaJavob>
}