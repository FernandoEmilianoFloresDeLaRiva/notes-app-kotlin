package com.example.moviles_223251_proyecto.home.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.home.data.services.GetNotesService
import com.example.moviles_223251_proyecto.home.domain.models.HomeState
import kotlinx.coroutines.launch

class HomeViewModel(app : Application) : AndroidViewModel(app) {
    val homeState = mutableStateOf<HomeState>(HomeState.Idle)
    private val userPreferences = UserPreferences(app)
    private val getNotesService = GetNotesService()

    init {
        getNotes()
    }

    private fun getNotes () {
        viewModelScope.launch {
            val userId = userPreferences.getUserId()?.toInt() ?: 0
            homeState.value = HomeState.Loading
            val result = getNotesService.getNotesService(userId)

            result.fold(
                onSuccess = { notesResponse ->
                    homeState.value = HomeState.Success(notesResponse)
                },
                onFailure = { exception ->
                    homeState.value = HomeState.Error(exception.message ?: "Error desconocido")
                }
            )
        }
    }
}