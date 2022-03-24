package com.example.network.repository.kirish

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.endtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.endtity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.endtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.endtity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.endtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.endtity.sms.smsKeldi.javob.SmsKeldiJavob
import com.example.network.endtity.sms.smsKeldi.surov.SmsKeldiSurov
import com.example.network.endtity.sms.telNumberJunatish.javob.SmsJavob
import com.example.network.endtity.sms.telNumberJunatish.surov.SmsSurov
import retrofit2.Response

class KirishRepository {

    suspend fun telJunatish(tel:String):Response<FooydalanuvchiniTekshirish> = RetrofitBuilder().kirshApi.telJunatish(tel)

    suspend fun ruyxatdanUtish(body: RuyxatdanUtishSurov):Response<RuyxatdanUtishJavob> = RetrofitBuilder().kirshApi.ruyxatdanUtish(body)


    suspend fun parolniTekshirish(body: ParolniTekshirishSurov):Response<ParolniTekshirishJavob> = RetrofitBuilder().kirshApi.parolniTekshirish(body)

    suspend fun sms(body: SmsSurov):Response<SmsJavob> = RetrofitBuilder().kirshApi.smsSurov(body)

    suspend fun smsKeldi(body: SmsKeldiSurov):Response<SmsKeldiJavob> = RetrofitBuilder().kirshApi.smsKeldi(body)
}