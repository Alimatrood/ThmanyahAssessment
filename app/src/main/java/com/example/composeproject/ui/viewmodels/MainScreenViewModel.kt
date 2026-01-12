package com.example.composeproject.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.data.models.mainscreen.HomeResponse
import com.example.composeproject.repositories.HomeScreenRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UiState {

    object Idle : UiState()

    object Loading : UiState()

    data class Success(val data: HomeResponse) : UiState()

    data class Error(val message: String) : UiState()

}


class MainViewModel : ViewModel() {

    private val repository = HomeScreenRepository()

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchHome()
    }

    private fun fetchHome() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            repository.getHomeItems()
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

    fun refresh() {
        fetchHome()
    }
}
