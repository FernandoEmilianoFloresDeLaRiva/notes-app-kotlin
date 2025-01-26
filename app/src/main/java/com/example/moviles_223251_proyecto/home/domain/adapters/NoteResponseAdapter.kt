package com.example.moviles_223251_proyecto.home.domain.adapters

import com.example.moviles_223251_proyecto.shared.domain.adapters.NoteCategoryResponseAdapter

data class NoteResponseAdapter(
    val id : Int,
    val title : String,
    val description : String,
    val active : Int,
    val archive : Int,
    var author : Int,
    var created_at : String,
    var id_category : List<NoteCategoryResponseAdapter>
)