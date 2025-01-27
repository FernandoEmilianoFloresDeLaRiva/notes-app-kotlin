package com.example.moviles_223251_proyecto.createnote.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles_223251_proyecto.core.domain.models.TextFieldConfig
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutFormApp
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.ui.styles.auth.AuthCommonStyles
import com.example.moviles_223251_proyecto.shared.ui.clickabletext.ClickableText
import com.example.moviles_223251_proyecto.shared.ui.customspacer.CustomSpacer
import com.example.moviles_223251_proyecto.shared.ui.customtext.CustomText
import com.example.moviles_223251_proyecto.shared.ui.textfield.CustomTextField

@Composable
fun CreateNotePage() {

    val textFields = listOf(
        TextFieldConfig(
            value = "",
            onValueChange = {  },
            label = "Titulo",
        ),
        TextFieldConfig(
            value = "",
            onValueChange = {},
            label = "Descripción",
        )
    )

    LayoutPage(
        content = { modifier ->
            LayoutFormApp(
                textFields = textFields,
                title = "Creemos una nueva nota para ti",
                buttonText = "Crear nota",
                modifier = modifier
            )
        }
    )
}