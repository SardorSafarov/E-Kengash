package com.example.network.repository.taxi

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.taxi.shaxarQidirsh.Javob.TaxsiShaxarQidirishJavob
import retrofit2.Response

class TaxiRepository {
    suspend fun taxiManzilQidirish(
        fields: String,
        input: String,
        inputtype: String,
        key: String,
    ): Response<TaxsiShaxarQidirishJavob> =
        RetrofitBuilder().taxiApi.taxiManzilQidirish(fields, input, inputtype, key)
}