package com.example.network.repository.kirish

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.netWorkEndtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.netWorkEndtity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.netWorkEndtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.netWorkEndtity.sms.smsKeldi.javob.SmsKeldiJavob
import com.example.network.netWorkEndtity.sms.smsKeldi.surov.SmsKeldiSurov
import com.example.network.netWorkEndtity.sms.telNumberJunatish.javob.SmsJavob
import com.example.network.netWorkEndtity.sms.telNumberJunatish.surov.SmsSurov
import retrofit2.Response

class KirishRepository {

    suspend fun telJunatish(tel:String):Response<FooydalanuvchiniTekshirish> = RetrofitBuilder().kirshApi.telJunatish(tel)

    suspend fun ruyxatdanUtish(body: RuyxatdanUtishSurov):Response<RuyxatdanUtishJavob> = RetrofitBuilder().kirshApi.ruyxatdanUtish(body)


    suspend fun parolniTekshirish(body: ParolniTekshirishSurov):Response<ParolniTekshirishJavob> = RetrofitBuilder().kirshApi.parolniTekshirish(body)

    suspend fun sms(body: SmsSurov):Response<SmsJavob> = RetrofitBuilder().kirshApi.smsSurov(body)

    suspend fun smsKeldi(body: SmsKeldiSurov):Response<SmsKeldiJavob> = RetrofitBuilder().kirshApi.smsKeldi(body)
}