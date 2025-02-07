package com.example.moviles_223251_proyecto.home.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.appDatabase.AppDatabase
import com.example.moviles_223251_proyecto.core.data.local.users.dao.UserDAO
import com.example.moviles_223251_proyecto.home.data.services.GetNotesService
import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter
import com.example.moviles_223251_proyecto.home.domain.models.HomeState
import kotlinx.coroutines.launch

class HomeViewModel(app : Application) : AndroidViewModel(app) {
    val homeState = mutableStateOf<HomeState>(HomeState.Idle)
    val username = mutableStateOf<String>("")
    private val userPreferences = UserPreferences(app)
    private val userDao = AppDatabase.getDatabase(app).userDao()
    private val getNotesService = GetNotesService()
    private var userId = mutableIntStateOf(0)
    val searchQuery = mutableStateOf("")
    private val orignalNotes = mutableListOf<NoteResponseAdapter>()

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
                    orignalNotes.clear()
                    orignalNotes.addAll(notesResponse)
                    homeState.value = HomeState.Success(orignalNotes)
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

    fun searchNotesByVoice(query: String) {
        searchQuery.value = query
        viewModelScope.launch {
            val currentState = homeState.value
            if (currentState is HomeState.Success) {
                val filteredNotes = orignalNotes.filter {
                    it.title.contains(query, ignoreCase = true) ||
                            it.description.contains(query, ignoreCase = true)
                }
                homeState.value = HomeState.Success(filteredNotes)
            } else {
                homeState.value = HomeState.Error("No hay notas disponibles para buscar.")
            }
        }
    }

    fun restoreNotes() {
        viewModelScope.launch {
            homeState.value = HomeState.Success(orignalNotes)
        }
    }
}