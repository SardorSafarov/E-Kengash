package com.example.katrip.kirish



import com.example.constants.Constants.URL_1
import com.example.constants.Constants.URL_VALYUTA
import com.example.network.api.*


import com.example.network.interceptor.MyInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_1)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val takliflarLayfxaklar:TakliflarLayfxaklar by lazy {
        retrofit.create(TakliflarLayfxaklar::class.java)
    }

    val kirshApi: KirshApi by lazy {
        retrofit.create(KirshApi::class.java)
    }

    val surovNomaApi: SurovNomaApi by lazy {
        retrofit.create(SurovNomaApi::class.java)
    }

    val kupBeriladiganSavollar:KupBeriladiganSavollar by lazy {
        retrofit.create(KupBeriladiganSavollar::class.java)
    }

    val profil:Profil by lazy {
        retrofit.create(Profil::class.java)
    }






    private val valyutaretrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_VALYUTA)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val valyutaApi: ValyutaApi by lazy {
        valyutaretrofit.create(ValyutaApi::class.java)
    }
}