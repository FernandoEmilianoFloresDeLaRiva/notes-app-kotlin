package com.example.moviles_223251_proyecto.register.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles_223251_proyecto.core.domain.TextFieldConfig
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutAuth
import com.example.moviles_223251_proyecto.core.ui.styles.auth.AuthCommonStyles
import com.example.moviles_223251_proyecto.routes.data.Routes
import com.example.moviles_223251_proyecto.shared.ui.clickabletext.ClickableText
import com.example.moviles_223251_proyecto.shared.ui.customspacer.CustomSpacer
import com.example.moviles_223251_proyecto.shared.ui.customtext.CustomText
import com.example.moviles_223251_proyecto.shared.ui.textfield.CustomTextField

@Composable
fun RegisterView(
    routerValue : MutableState<String>
) {
    val textFields = listOf(
        TextFieldConfig(
            value = "",
            onValueChange = { },
            label = "Username",
            leadingIcon = {
                Image(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "User icon",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }
        ),
        TextFieldConfig(
            value = "",
            onValueChange = { },
            label = "Email",
            leadingIcon = {
                Image(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email icon",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }
        ),
        TextFieldConfig(
            value = "",
            onValueChange = { },
            label = "Password",
            leadingIcon = {
                Image(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Lock icon",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }
        ),
    )
    LayoutAuth(
        textFields = textFields,
        layoutTitle = "¡Registrate!",
        primaryButtonTitle = "Crea tu cuenta",
        primaryButtonAction = {  },
        secondaryButtonTitle = "¿Ya tienes una cuenta?, Inicia Sesión",
        secondaryButtonAction = {
            routerValue.value = Routes.LoginRoute.route
        },
    )
}
