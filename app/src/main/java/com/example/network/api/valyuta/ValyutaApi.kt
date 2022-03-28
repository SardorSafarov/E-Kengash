package com.example.network.api.valyuta

import com.example.network.entity.valyuta.ValyutaEntity
import retrofit2.Response
import retrofit2.http.GET

interface ValyutaApi {
    @GET("/uz/arkhiv-kursov-valyut/json/")
    suspend fun valyuta():Response<ValyutaEntity>


}