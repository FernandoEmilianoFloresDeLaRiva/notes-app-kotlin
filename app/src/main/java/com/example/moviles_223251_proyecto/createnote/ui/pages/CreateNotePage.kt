package com.example.moviles_223251_proyecto.createnote.ui.pages

import androidx.compose.runtime.Composable
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutFormApp
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider

@Composable
fun CreateNotePage() {
    val createNoteViewModel = LocalViewModelProvider.current.createNoteViewModel

    LayoutPage(
        username = createNoteViewModel.username.value,
        content = { modifier ->
            LayoutFormApp(
                textFields = createNoteViewModel.getTextFields(),
                title = "Creemos una nueva nota para ti",
                buttonText = "Crear nota",
                modifier = modifier
            )
        }
    )
}