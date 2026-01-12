package com.example.composeproject.api.mainscreen

import com.example.composeproject.data.models.mainscreen.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainScreenApiService {

    @GET("/home_sections")
    suspend fun getHomeItems(): Response<HomeResponse>
}
