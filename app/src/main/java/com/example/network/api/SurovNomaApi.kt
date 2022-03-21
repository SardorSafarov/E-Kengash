package com.example.network.api


import com.example.network.netWorkEndtity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface SurovNomaApi {

    @GET("/api/v1/info/survey/{qiziqish_id}")
    suspend fun surovnoma(@Header("authorization") token: String,@Path(value = "qiziqish_id")qiziqsh_id:Int): Response<SurovNoma1ViewJavob>

}