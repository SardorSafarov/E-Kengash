package com.example.network.repository.valyuta

import com.example.ekengash.kirish.RetrofitBuilder

class ValyutaRepository {
    suspend fun valyuta() = RetrofitBuilder().valyutaApi.valyuta()
}