package com.example.moviles_223251_proyecto.core.ui.composables.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.navigation.states.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.currentRoute
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo
import com.example.moviles_223251_proyecto.core.ui.composables.navbar.composables.itembar.ItemBar

@Composable
fun NavBar() {
    val route = LocalRouter.current
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.primary
            )
            .padding(12.dp)
            .fillMaxWidth()
    ){
        for(page in Routes.pages) {
            ItemBar(
                page,
                selected = route.currentRoute() == page.route,
                modifier = Modifier.clickable {
                    route.navigateTo(page.route)
                }
            )
        }
    }
}