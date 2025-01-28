package com.example.moviles_223251_proyecto.home.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.appDatabase.AppDatabase
import com.example.moviles_223251_proyecto.core.data.local.users.dao.UserDAO
import com.example.moviles_223251_proyecto.home.data.services.GetNotesService
import com.example.moviles_223251_proyecto.home.domain.models.HomeState
import kotlinx.coroutines.launch

class HomeViewModel(app : Application) : AndroidViewModel(app) {
    val homeState = mutableStateOf<HomeState>(HomeState.Idle)
    val username = mutableStateOf<String>("")
    private val userPreferences = UserPreferences(app)
    private val userDao = AppDatabase.getDatabase(app).userDao()
    private val getNotesService = GetNotesService()
    private var userId = mutableIntStateOf(0)

    init {
        getUsername()
        getNotes()
    }

    fun getNotes () {
        viewModelScope.launch {
            homeState.value = HomeState.Loading
            val result = getNotesService.getNotesService(userId.intValue)

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

    private fun getUsername () {
        viewModelScope.launch {
            userId.intValue = userPreferences.getUserId()?.toInt() ?: 0
            val user = userDao.getUserById(userId.intValue)
            username.value = user?.username ?: ""
        }
    }

    fun restartState() {
        homeState.value = HomeState.Idle
    }
}