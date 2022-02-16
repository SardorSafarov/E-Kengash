package com.example.network.repository

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.endtity.foydalanuvchiBor.FooydalanuvchiniTekshirish
import com.example.network.endtity.ruyxatdanUtish.javob.RuyxatdanUtishJavob
import com.example.network.endtity.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import retrofit2.Response

class KirishRepository {

    suspend fun telJunatish(tel:String):Response<FooydalanuvchiniTekshirish> = RetrofitBuilder().kirshApi.telJunatish(tel)

    suspend fun ruyxatdanUtish(body:RuyxatdanUtishSurov):Response<RuyxatdanUtishJavob> = RetrofitBuilder().kirshApi.ruyxatdanUtish(body)
}