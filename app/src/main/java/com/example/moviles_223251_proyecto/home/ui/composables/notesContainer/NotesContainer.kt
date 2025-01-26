package com.example.moviles_223251_proyecto.home.ui.composables.notesContainer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter
import com.example.moviles_223251_proyecto.home.ui.composables.noteItem.NoteItem

@Composable
fun NotesContainer(
    notes : List<NoteResponseAdapter>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues( vertical = 20.dp)
    ){
        items(notes.size){
            NoteItem(note = notes[it])
        }
    }
}