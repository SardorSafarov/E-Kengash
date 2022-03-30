package com.example.network.repository.surovNoma

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.entity.surovNoma.surovNomaJavob.SurovNomaJavob
import com.example.network.entity.taxi.haydovchi.javob.HaydovchiIzlashJavob
import retrofit2.Response


class SurovNomaRepository {

    suspend fun surovNoma(token: String, qizqish_id: Int): Response<SurovNoma1ViewJavob> =
        RetrofitBuilder().surovNomaApi.surovNoma(token, qizqish_id)

    suspend fun surovNomaJavob(token: String, surovNomaJavob: SurovNomaJavob) =
        RetrofitBuilder().surovNomaApi.surovNomaJavobi(token, surovNomaJavob)


    suspend fun haydovchiIzlash(
        token: String,
        from_lat: String,
        from_lng: String,
        to_lat: String,
        to_lng: String,
        date: String,
        from_place: String,
        to_place: String,
    ): Response<HaydovchiIzlashJavob> = RetrofitBuilder().surovNomaApi.haydovchiIzlash(token,from_lat,
        from_lng, to_lat, to_lng, date, from_place, to_place)


}