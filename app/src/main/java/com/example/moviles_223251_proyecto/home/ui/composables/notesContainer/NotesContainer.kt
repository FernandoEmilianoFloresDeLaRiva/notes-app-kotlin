package com.example.moviles_223251_proyecto.home.ui.composables.notesContainer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter
import com.example.moviles_223251_proyecto.home.ui.composables.noteItem.NoteItem

@Composable
fun NotesContainer(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues( vertical = 20.dp)
    ){
        item {
            for (i in 0..10){
                NoteItem(
                    note = NoteResponseAdapter(
                        id = i,
                        title = "Nota $i",
                        description = "Contenido de la nota $i",
                        active = 1,
                        archive = 0,
                        author = 1,
                        created_at = "2021-10-10T10:10:10",
                        id_category = listOf()
                    )
                )
            }
        }
    }
}