package com.example.moviles_223251_proyecto.core.navigation.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import com.example.moviles_223251_proyecto.core.domain.NavItem

object Routes {
    val RegisterRoute = "register"
    val LoginRoute = NavItem("Logout", "login", Icons.Outlined.ExitToApp)
    val HomeRoute = NavItem("Home", "home", Icons.Outlined.Home)
    val CreateRoute = NavItem("Create", "create", Icons.Outlined.AddCircle)

    val pages = listOf<NavItem>(HomeRoute, CreateRoute, LoginRoute)
}