package com.example.network.api


import com.example.network.endtity.foydalanuvchiBor.FooydalanuvchiniTekshirish
import com.example.network.endtity.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.endtity.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface KirshApi {

    @GET("/api/v1/check:{phone}")
    suspend fun telJunatish(@Path("phone") tel: String): Response<FooydalanuvchiniTekshirish>

    @POST("/api/v1/sign-up")
    suspend fun ruyxatdanUtish(@Body body: RuyxatdanUtishSurov): Response<RuyxatdanUtishJavob>

}