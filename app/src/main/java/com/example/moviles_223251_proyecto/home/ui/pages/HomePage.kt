package com.example.moviles_223251_proyecto.home.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider
import com.example.moviles_223251_proyecto.home.domain.models.HomeState
import com.example.moviles_223251_proyecto.home.ui.composables.notesContainer.NotesContainer
import com.example.moviles_223251_proyecto.home.ui.composables.searcNotes.SearchNotes
import com.example.moviles_223251_proyecto.shared.ui.errormessage.ErrorMessage
import com.example.moviles_223251_proyecto.shared.ui.loader.Loader
import kotlinx.coroutines.delay

@Composable
fun HomePage() {
    val homeViewModel = LocalViewModelProvider.current.homeViewModel
    val homeState by homeViewModel.homeState

    LayoutPage(
        username = homeViewModel.username.value,
        content = { modifier ->
            Column(
                modifier = modifier.fillMaxSize()
            ){
                when (homeState) {
                    is HomeState.Loading -> {
                        Loader(modifier = modifier)
                    }
                    is HomeState.Success -> {
                        SearchNotes(homeViewModel = homeViewModel)
                        NotesContainer(
                            notes = (homeState as HomeState.Success).notesResponse,)
                    }
                    is HomeState.Error -> {
                        val errorMessage = (homeState as HomeState.Error).message
                        ErrorMessage(message = errorMessage, modifier = modifier)
                        LaunchedEffect(Unit) {
                            delay(2000)
                            homeViewModel.restartState()
                        }
                    }
                    is HomeState.Idle -> {}
                }
            }
        }
    )
}