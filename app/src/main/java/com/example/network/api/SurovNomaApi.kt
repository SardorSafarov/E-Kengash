package com.example.network.api


import com.example.network.entity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.entity.surovNoma.surovNomaJavob.SurovNomaJavob
import retrofit2.Response
import retrofit2.http.*


interface SurovNomaApi {

    @GET("/api/v1/info/survey/{qiziqish_id}")
    suspend fun surovNoma(@Header("authorization") token: String, @Path(value = "qiziqish_id")qiziqsh_id:Int): Response<SurovNoma1ViewJavob>

    @POST("api/v1/me/surveyans")
    suspend fun surovNomaJavobi(@Header("authorization") token:String,@Body body:SurovNomaJavob)
}