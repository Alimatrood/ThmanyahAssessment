package com.example.composeproject.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.data.models.mainscreen.HomeResponse
import com.example.composeproject.repositories.HomeScreenRepository
import com.example.composeproject.repositories.SearchScreenRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SearchScreenViewModel: ViewModel(){

    private val repository = SearchScreenRepository()

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun search(query: String) {
        if (query.isEmpty()) {
            _uiState.value = UiState.Idle
            return
        }
        
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            repository.getSearchItems()
                .onSuccess { homeResponse ->
                    _uiState.value = UiState.Success(homeResponse)
                }
                .onFailure { exception ->
                    _uiState.value = UiState.Error(
                        exception.message ?: "An error occurred while retrieving data."
                    )
                }
        }
    }

}
