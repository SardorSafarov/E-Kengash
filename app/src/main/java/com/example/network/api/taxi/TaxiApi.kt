package com.example.network.api.taxi

import com.example.network.entity.taxi.shaxarQidirsh.Javob.TaxsiShaxarQidirishJavob
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TaxiApi {

    @GET("/maps/api/place/findplacefromtext/json?fields=formatted_address%2Cname%2Cgeometry")
    suspend fun taxiManzilQidirish(
        @Query("input") input: String,
        @Query("inputtype") inputtype: String,
        @Query("key") key: String,
    ): Response<TaxsiShaxarQidirishJavob>

}