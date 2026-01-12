package com.example.composeproject.api.searchscreen

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchScreenRetrofitInstance {
    private val SearchScreenRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://mock.apidog.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val SearchScreenApiServiceVar: SearchScreenApiService by lazy { SearchScreenRetrofit.create(SearchScreenApiService::class.java)
    }
}