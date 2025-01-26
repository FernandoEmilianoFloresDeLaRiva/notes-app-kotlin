package com.example.moviles_223251_proyecto.core.vmprovider.states

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.example.moviles_223251_proyecto.core.domain.models.ViewModelManager

@Composable
fun ViewModelManagerProvider(
    context : Context,
    content: @Composable () -> Unit
) {
    val viewModelManager = remember{ ViewModelManager(context = context) }

    CompositionLocalProvider(LocalViewModelProvider provides viewModelManager) {
        content()
    }
}