package com.example.moviles_223251_proyecto.home.ui.composables.searcNotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.moviles_223251_proyecto.home.ui.composables.RequestPermission.RequestPermission
import com.example.moviles_223251_proyecto.home.ui.viewmodels.HomeViewModel
import com.example.moviles_223251_proyecto.shared.helpers.VoiceSearchUtil

@Composable
fun SearchNotes( homeViewModel: HomeViewModel,modifier: Modifier = Modifier) {
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

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
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
            Text("Todas las notas")
        }
    }

}