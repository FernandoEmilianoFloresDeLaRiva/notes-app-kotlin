package com.example.moviles_223251_proyecto.createnote.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutFormApp
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider
import com.example.moviles_223251_proyecto.createnote.domain.models.CreateNoteState
import com.example.moviles_223251_proyecto.shared.ui.errormessage.ErrorMessage
import com.example.moviles_223251_proyecto.shared.ui.loader.Loader
import com.example.moviles_223251_proyecto.shared.ui.successmessage.SuccessMessage
import kotlinx.coroutines.delay

@Composable
fun CreateNotePage() {
    val homeViewModel = LocalViewModelProvider.current.homeViewModel
    val createNoteViewModel = LocalViewModelProvider.current.createNoteViewModel
    val createNoteState by createNoteViewModel.createNoteState

    LayoutPage(
        username = createNoteViewModel.username.value,
        content = { modifier ->
            LayoutFormApp(
                textFields = createNoteViewModel.getTextFields(),
                title = "Creemos una nueva nota para ti",
                buttonText = "Crear nota",
                buttonAction = {
                    createNoteViewModel.createNote()
                },
                modifier = modifier
            )

            if(createNoteState is CreateNoteState.Success){
                val title = (createNoteState as CreateNoteState.Success).createNoteResponse.title
                SuccessMessage(message = "Nota con titulo $title creada con exito" , modifier = modifier)
                homeViewModel.getNotes()
                LaunchedEffect(Unit) {
                    delay(2000)
                    createNoteViewModel.resetState()
                }
            }

            if(createNoteState is CreateNoteState.Loading){
                Loader(modifier = modifier)
            }else if(createNoteState is CreateNoteState.Error){
                ErrorMessage(message = (createNoteState as CreateNoteState.Error).message, modifier = modifier)
                LaunchedEffect(Unit) {
                    delay(2000)
                    createNoteViewModel.resetState()
                }
            }
        }
    )
}