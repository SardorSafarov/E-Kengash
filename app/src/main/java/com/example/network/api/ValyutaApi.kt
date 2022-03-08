package com.example.network.api

import com.example.network.netWorkEndtity.valyuta.ValyutaEntity
import retrofit2.Response
import retrofit2.http.GET

interface ValyutaApi {
    @GET("/uz/arkhiv-kursov-valyut/json/")
    suspend fun valyuta():Response<ValyutaEntity>
}