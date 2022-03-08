package com.example.network.repository

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.netWorkEndtity.kirsh.foydalanuvchiniTekshirsh.FooydalanuvchiniTekshirish
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.javob.ParolniTekshirishJavob
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.netWorkEndtity.kirsh.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.netWorkEndtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import retrofit2.Response

class KirishRepository {

    suspend fun telJunatish(tel:String):Response<FooydalanuvchiniTekshirish> = RetrofitBuilder().kirshApi.telJunatish(tel)

    suspend fun ruyxatdanUtish(body: RuyxatdanUtishSurov):Response<RuyxatdanUtishJavob> = RetrofitBuilder().kirshApi.ruyxatdanUtish(body)


    suspend fun parolniTekshirish(body: ParolniTekshirishSurov):Response<ParolniTekshirishJavob> = RetrofitBuilder().kirshApi.parolniTekshirish(body)


}