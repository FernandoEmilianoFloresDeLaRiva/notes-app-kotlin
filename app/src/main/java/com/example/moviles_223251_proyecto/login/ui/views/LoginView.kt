package com.example.moviles_223251_proyecto.login.ui.views

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
import com.example.moviles_223251_proyecto.routes.data.Routes
import com.example.moviles_223251_proyecto.shared.ui.clickabletext.ClickableText
import com.example.moviles_223251_proyecto.shared.ui.customspacer.CustomSpacer
import com.example.moviles_223251_proyecto.shared.ui.customtext.CustomText
import com.example.moviles_223251_proyecto.shared.ui.textfield.CustomTextField

@Composable
fun LoginView(
    routerValue : MutableState<String>
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inversePrimary)
    ){
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = LoginViewStyles.boxStyle(MaterialTheme.colorScheme)
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText(
                    text = "¡Ingresa a tus notas!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                CustomSpacer(modifier = Modifier.height(12.dp))

                CustomTextField(
                    value = "",
                    onValueChange = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent, RoundedCornerShape(8.dp)),
                    colors = LoginViewStyles.getTextFieldColors(MaterialTheme.colorScheme),
                    label = { Text("Email") },
                    leadingIcon = {
                        Image(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "User icon",
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )
                    }
                )

                CustomTextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent, RoundedCornerShape(8.dp)),
                    label = { Text("Password") },
                    colors = LoginViewStyles.getTextFieldColors(MaterialTheme.colorScheme),
                    leadingIcon = {
                        Image(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "Lock icon",
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )
                    },
                )

                CustomSpacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomText(
                        text = "Inicia Sesión",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                }

                CustomSpacer(modifier = Modifier.height(12.dp))

                ClickableText(
                    text = "¿No cuentas con una cuenta?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.primary,
                    onClick = {
                        routerValue.value = Routes.RegisterRoute
                    },
                )
            }
        }
    }
}