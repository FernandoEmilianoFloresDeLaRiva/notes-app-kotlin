package com.example.moviles_223251_proyecto.createnote.domain.adapters

data class CreateNoteResponseAdapter (
    val title: String,
    val description: String,
    val author: Int,
    val id : Int,
    val active: Int,
    val archive: Int,
    val created_at: String
)