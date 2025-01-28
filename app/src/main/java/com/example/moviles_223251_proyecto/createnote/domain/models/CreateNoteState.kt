package com.example.moviles_223251_proyecto.createnote.domain.models

import com.example.moviles_223251_proyecto.createnote.domain.adapters.CreateNoteResponseAdapter

sealed class CreateNoteState {
    data object Idle : CreateNoteState()
    data object Loading : CreateNoteState()
    data class Success(val createNoteResponse : CreateNoteResponseAdapter) : CreateNoteState()
    data class Error(val message: String) : CreateNoteState()
}