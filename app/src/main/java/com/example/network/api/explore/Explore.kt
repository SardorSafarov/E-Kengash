package com.example.network.api.explore

import com.example.network.entity.explore.shaxarichi.ShaxarIchidaJavob
import com.example.network.entity.explore.shaxarlar.javob.ShaxarlarJavob
import com.example.network.entity.info.javob.InfoJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Explore {


    @GET("/api/v1/explore/category")
    suspend fun shaxarlar(@Header("authorization") token: String, @Query("father_id")father_id:String,@Query("like")id:String,@Query("lang_code")til:String): Response<ShaxarlarJavob>

    @GET("/api/v1/explore/find/category")
    suspend fun shaxarlarIchida(@Header("authorization") token: String, @Query("explore_category_id")category_id:String,@Query("like")id:String,@Query("lang_code")til:String): Response<ShaxarIchidaJavob>

}