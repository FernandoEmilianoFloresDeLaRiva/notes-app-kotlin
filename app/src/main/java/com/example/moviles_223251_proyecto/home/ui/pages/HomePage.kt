package com.example.moviles_223251_proyecto.home.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider
import com.example.moviles_223251_proyecto.home.domain.models.HomeState
import com.example.moviles_223251_proyecto.home.ui.composables.notesContainer.NotesContainer
import com.example.moviles_223251_proyecto.shared.ui.errormessage.ErrorMessage
import com.example.moviles_223251_proyecto.shared.ui.loader.Loader

@Composable
fun HomePage() {
    val homeViewModel = LocalViewModelProvider.current.homeViewModel
    val homeState by homeViewModel.homeState
    LayoutPage(
        username = homeViewModel.username.value,
        content = { modifier ->
            if (homeState is HomeState.Loading){
                Loader(modifier = modifier)
            } else if (homeState is HomeState.Success){
                NotesContainer(notes = (homeState as HomeState.Success).notesResponse, modifier = modifier)
            } else {
                val errorMessage = (homeState as HomeState.Error).message
                ErrorMessage(message = errorMessage, modifier = modifier)
            }
        }
    )
}