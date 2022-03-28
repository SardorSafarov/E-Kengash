package com.example.network.repository.kirish

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.explore.engYaqin.EngYaqinJavob
import com.example.network.entity.explore.shaxarichi.ShaxarIchidaJavob
import com.example.network.entity.explore.shaxarlar.javob.ShaxarlarJavob
import retrofit2.Response


class ExploreRepository {

    suspend fun shaxarlar(tel:String,query:String,id:String,til:String): Response<ShaxarlarJavob> = RetrofitBuilder().explore.shaxarlar(tel,query,id,til)

    suspend fun shaxarlarIchida(tel:String,query:String,id:String,til:String): Response<ShaxarIchidaJavob> = RetrofitBuilder().explore.shaxarlarIchida(tel,query,id,til)

    suspend fun engYaqinKategoriiyaBtn(tel:String,query:String,id:String): Response<EngYaqinJavob> = RetrofitBuilder().explore.engYaqinKategoriiyaBtn(tel,query,id)
}