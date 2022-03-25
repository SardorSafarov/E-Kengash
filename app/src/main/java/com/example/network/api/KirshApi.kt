package com.example.network.api


import com.example.network.entity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.entity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.entity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.entity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.entity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.entity.sms.smsKeldi.javob.SmsKeldiJavob
import com.example.network.entity.sms.smsKeldi.surov.SmsKeldiSurov
import com.example.network.entity.sms.telNumberJunatish.javob.SmsJavob
import com.example.network.entity.sms.telNumberJunatish.surov.SmsSurov
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

    @POST("/api/v1/sms")
    suspend fun smsSurov(@Body body: SmsSurov):Response<SmsJavob>

    @POST("/api/v1/token")
    suspend fun smsKeldi(@Body body: SmsKeldiSurov):Response<SmsKeldiJavob>
}