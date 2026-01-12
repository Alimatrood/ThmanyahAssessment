package com.example.composeproject.api.mainscreen

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MainScreenRetrofitInstance {

    private val MainScreenRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api-v2-b2sit6oh3a-uc.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val mainScreenApiService: MainScreenApiService by lazy {
        MainScreenRetrofit.create(MainScreenApiService::class.java)
    }

}

