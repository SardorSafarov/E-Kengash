package com.example.network.api.surovnoma


import com.example.network.entity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.entity.surovNoma.surovNomaJavob.SurovNomaJavob
import com.example.network.entity.taxi.haydovchi.javob.HaydovchiIzlashJavob
import retrofit2.Response
import retrofit2.http.*


interface SurovNomaApi {

    @GET("/api/v1/info/survey/{qiziqish_id}")
    suspend fun surovNoma(@Header("authorization") token: String, @Path(value = "qiziqish_id")qiziqsh_id:Int): Response<SurovNoma1ViewJavob>

    @POST("api/v1/me/surveyans")
    suspend fun surovNomaJavobi(@Header("authorization") token:String,@Body body:SurovNomaJavob)


    @GET("/api/v1/taxi")
    suspend fun haydovchiIzlash(
                                @Header("authorization") token: String,
                                @Query("from_lat") from_lat:String,
                                @Query("from_lng") from_lng:String,
                                @Query("to_lat") to_lat:String,
                                @Query("to_lng") to_lng:String,
                                @Query("date") date:String,
                                @Query("from_place") from_place:String,
                                @Query("to_place") to_place:String,
                ): Response<HaydovchiIzlashJavob>


}