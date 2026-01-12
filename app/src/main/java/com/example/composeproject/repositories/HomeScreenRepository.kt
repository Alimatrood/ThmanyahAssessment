package com.example.composeproject.repositories

import com.example.composeproject.data.models.mainscreen.HomeResponse
import com.example.composeproject.api.mainscreen.MainScreenRetrofitInstance

class HomeScreenRepository {

    private val apiService = MainScreenRetrofitInstance.mainScreenApiService

    suspend fun getHomeItems(): Result<HomeResponse> {
        return try {
            val response = apiService.getHomeItems()
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Response body is null"))
            } else {
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

