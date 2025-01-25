package com.example.moviles_223251_proyecto.core.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles_223251_proyecto.core.domain.TextFieldConfig
import com.example.moviles_223251_proyecto.core.ui.styles.auth.AuthCommonStyles
import com.example.moviles_223251_proyecto.shared.ui.clickabletext.ClickableText
import com.example.moviles_223251_proyecto.shared.ui.customspacer.CustomSpacer
import com.example.moviles_223251_proyecto.shared.ui.customtext.CustomText
import com.example.moviles_223251_proyecto.shared.ui.textfield.CustomTextField

@Composable
fun LayoutAuth(
    textFields: List<TextFieldConfig>,
    layoutTitle : String = "",
    primaryButtonTitle : String = "",
    primaryButtonAction : () -> Unit,
    secondaryButtonTitle : String = "",
    secondaryButtonAction : () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inversePrimary)
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = AuthCommonStyles.boxStyle(MaterialTheme.colorScheme)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText(
                    text = layoutTitle,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                CustomSpacer(modifier = Modifier.height(12.dp))

                textFields.forEach { config ->
                    CustomTextField(
                        value = config.value,
                        onValueChange = config.onValueChange,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent, RoundedCornerShape(8.dp)),
                        colors = AuthCommonStyles.getTextFieldColors(MaterialTheme.colorScheme),
                        label = { Text(config.label) },
                        leadingIcon = config.leadingIcon
                    )
                }

                CustomSpacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = primaryButtonAction,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomText(
                        text = primaryButtonTitle,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.surfaceBright
                    )
                }

                CustomSpacer(modifier = Modifier.height(12.dp))

                ClickableText(
                    text = secondaryButtonTitle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    onClick = {
                        secondaryButtonAction()
                    },
                )
            }
        }
    }
}