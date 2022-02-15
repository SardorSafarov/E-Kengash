package com.example.network.api

import com.example.network.endtity.KirishEntiyt1
import com.example.network.endtity.kirish.KirishEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface KirshApi {
    @GET("/api/v1/check:{phone}")
    suspend fun telJunatish(@Path("phone") employeeId: String): Response<KirishEntiyt1>
}