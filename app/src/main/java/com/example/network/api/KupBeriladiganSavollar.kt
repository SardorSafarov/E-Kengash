package com.example.network.api

import com.example.network.netWorkEndtity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import com.example.network.netWorkEndtity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface KupBeriladiganSavollar {

    @GET("/api/v1/info/faq")
    suspend fun kupBeriladiganSavollar(@Header("authorization") token: String, ): Response<KupBeriladiganSavollarJavob>

}