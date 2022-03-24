package com.example.network.repository.takliflarLayfxaklar

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.endtity.takliflarLayfxaklar.javob.TakliflarLayfxaklarJavob
import retrofit2.Response

class TakliflarLayfxaklarRepisitory {

    suspend fun takliflarLayfxaklar (token:String,query:String):Response<TakliflarLayfxaklarJavob> = RetrofitBuilder().takliflarLayfxaklar.takliflarLayfxaklar(token,query)
}