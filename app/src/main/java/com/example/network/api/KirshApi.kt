package com.example.network.api


import com.example.network.endtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.endtity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.endtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.endtity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.endtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
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

    @POST("/api/v1/sign-in")
    suspend fun parolniTekshirish(@Body body: ParolniTekshirishSurov): Response<ParolniTekshirishJavob>

}