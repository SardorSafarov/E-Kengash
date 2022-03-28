package com.example.network.repository.turarJoy

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.turarJoy.izlash.TurarJoyIzlashJavob
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
}