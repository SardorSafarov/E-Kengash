package com.example.network.repository.turarJoy

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.turarJoy.izlash.TurarJoyIzlashJavob
import com.example.network.entity.turarJoy.xona.javob.TurarJoyXonaHaqida
import retrofit2.Response

class TurarJoyRepository {

    suspend fun turarJoyIzlash(
        token: String,
        people: String,
        child: String,
        city: String,
        lang_code: String,
    ): Response<TurarJoyIzlashJavob> =
        RetrofitBuilder().turarJoyApi.turarJoyIzlash(token, people, child, city, lang_code)


    suspend fun turarJoyXona(
        token: String,
        id: String,
        lang_code: String,
    ): Response<TurarJoyXonaHaqida> = RetrofitBuilder().turarJoyApi.turarJoyXona(token,id,lang_code)


}