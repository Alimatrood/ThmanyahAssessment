package com.example.composeproject.api.searchscreen

import com.example.composeproject.data.models.mainscreen.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface SearchScreenApiService {


    @GET("/m1/735111-711675-default/search")
    suspend fun getSearchItems(): Response<HomeResponse>
}