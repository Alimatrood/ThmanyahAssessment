package com.example.composeproject.repositories

import com.example.composeproject.api.searchscreen.SearchScreenRetrofitInstance
import com.example.composeproject.data.models.mainscreen.HomeResponse

class SearchScreenRepository {

        private val apiService = SearchScreenRetrofitInstance.SearchScreenApiServiceVar

        suspend fun getSearchItems(): Result<HomeResponse> {
            return try {
                val response = apiService.getSearchItems()
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