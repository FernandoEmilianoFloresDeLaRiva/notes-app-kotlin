package com.example.moviles_223251_proyecto.home.domain.models

import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter

sealed class HomeState {
    data object Idle : HomeState()
    data object Loading : HomeState()
    data class Success(val notesResponse : List<NoteResponseAdapter>) : HomeState()
    data class Error(val message: String) : HomeState()
}