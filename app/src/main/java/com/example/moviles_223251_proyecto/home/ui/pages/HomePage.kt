package com.example.moviles_223251_proyecto.home.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider
import com.example.moviles_223251_proyecto.home.domain.models.HomeState
import com.example.moviles_223251_proyecto.home.ui.composables.RequestPermission.RequestPermission
import com.example.moviles_223251_proyecto.home.ui.composables.notesContainer.NotesContainer
import com.example.moviles_223251_proyecto.shared.helpers.VoiceSearchUtil
import com.example.moviles_223251_proyecto.shared.ui.errormessage.ErrorMessage
import com.example.moviles_223251_proyecto.shared.ui.loader.Loader
import kotlinx.coroutines.delay

@Composable
fun HomePage() {
    val homeViewModel = LocalViewModelProvider.current.homeViewModel
    val homeState by homeViewModel.homeState
    val ctx = LocalContext.current
    var isPermissionGranted by remember { mutableStateOf(false) }

    RequestPermission {
        isPermissionGranted = true
    }
    val voiceSearchUtil = remember {
        VoiceSearchUtil(ctx){ recognizedText ->
            homeViewModel.searchNotesByVoice(recognizedText)
        }
    }

    LayoutPage(
        username = homeViewModel.username.value,
        content = { modifier ->
            Column(
                modifier = modifier.fillMaxSize()
            ){
                Button(
                    onClick = {
                        if (isPermissionGranted) voiceSearchUtil.startListening()
                    },
                    modifier = Modifier.padding(8.dp),
                    enabled = isPermissionGranted
                ) {
                    Icon(Icons.Default.Mic, contentDescription = "Buscar por voz")
                    Text("Buscar por voz")
                }

                Button(
                    onClick = { homeViewModel.restoreNotes() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Mostrar todas las notas")
                }
                when (homeState) {
                    is HomeState.Loading -> {
                        Loader(modifier = modifier)
                    }
                    is HomeState.Success -> {
                        NotesContainer(
                            notes = (homeState as HomeState.Success).notesResponse,
                            modifier = modifier
                        )
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