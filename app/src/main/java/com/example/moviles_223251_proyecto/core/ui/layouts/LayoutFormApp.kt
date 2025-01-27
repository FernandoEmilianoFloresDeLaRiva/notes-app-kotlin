package com.example.moviles_223251_proyecto.core.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles_223251_proyecto.core.domain.models.TextFieldConfig
import com.example.moviles_223251_proyecto.core.ui.styles.LayoutAppForm.LayoutAppFormStyles
import com.example.moviles_223251_proyecto.shared.ui.customspacer.CustomSpacer
import com.example.moviles_223251_proyecto.shared.ui.customtext.CustomText
import com.example.moviles_223251_proyecto.shared.ui.textfield.CustomTextField

@Composable
fun LayoutFormApp(
    modifier: Modifier = Modifier,
    textFields: List<TextFieldConfig>,
    title : String = "",
    buttonText : String = "",
    buttonAction : () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = LayoutAppFormStyles.boxStyle(modifier, MaterialTheme.colorScheme)
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            CustomSpacer(modifier = Modifier.height(12.dp))

            textFields.forEach { config ->
                CustomTextField(
                    value = config.value,
                    onValueChange = config.onValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent, RoundedCornerShape(8.dp)),
                    colors = LayoutAppFormStyles.getTextFieldColors(MaterialTheme.colorScheme),
                    label = { Text(config.label) },
                    leadingIcon = config.leadingIcon
                )
            }

            CustomSpacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = buttonAction,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomText(
                    text = buttonText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.surfaceBright
                )
            }
        }
    }
}