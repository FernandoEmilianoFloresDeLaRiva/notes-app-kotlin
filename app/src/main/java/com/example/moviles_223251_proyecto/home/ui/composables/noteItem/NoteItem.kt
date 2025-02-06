package com.example.moviles_223251_proyecto.home.ui.composables.noteItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter
import com.example.moviles_223251_proyecto.shared.helpers.TextToSpeechHelper
import com.example.moviles_223251_proyecto.shared.ui.customspacer.CustomSpacer
import com.example.moviles_223251_proyecto.shared.ui.customtext.CustomText

@Composable
fun NoteItem(
    note : NoteResponseAdapter
) {
    val ctx = LocalContext.current
    val textToSpeechHelper = rememberSaveable{ TextToSpeechHelper(ctx) }
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .graphicsLayer {
                shadowElevation = 15.dp.toPx()
                shape = RoundedCornerShape(15.dp)
                clip = true
            }
            .background(
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = RoundedCornerShape(16.dp)
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
            CustomText(
                text = note.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            CustomSpacer(Modifier.height(10.dp))
            CustomText(
                text = note.description,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 17.sp,
                fontWeight = FontWeight(500)
            )
            CustomSpacer(Modifier.height(18.dp))
            CustomText(
                text = note.getFormattedDate(),
                color = MaterialTheme.colorScheme.primaryContainer,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
            Button(
                onClick = {
                    textToSpeechHelper.speak(
                        "Titulo ${note.title} Descripción ${note.description} Fecha ${note.getFormattedDate()}"
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(60.dp),
                modifier = Modifier
                    .align(Alignment.End)
                    .size(50.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Play",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                )
            }
        }
    }
}