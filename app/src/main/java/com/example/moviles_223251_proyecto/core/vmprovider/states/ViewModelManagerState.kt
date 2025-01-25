package com.example.moviles_223251_proyecto.core.vmprovider.states

import androidx.compose.runtime.compositionLocalOf
import com.example.moviles_223251_proyecto.core.domain.ViewModelManager

val LocalViewModelProvider = compositionLocalOf<ViewModelManager> {
    error("No ViewModelProvider found in CompositionLocal")
}