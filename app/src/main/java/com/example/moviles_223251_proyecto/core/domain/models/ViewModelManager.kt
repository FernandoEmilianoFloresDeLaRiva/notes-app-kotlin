package com.example.moviles_223251_proyecto.core.domain.models

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviles_223251_proyecto.home.ui.viewmodels.HomeViewModel
import com.example.moviles_223251_proyecto.login.ui.viewmodels.LoginViewModel
import com.example.moviles_223251_proyecto.register.ui.viewmodels.RegisterViewModel

class ViewModelManager(private val context: Context) {

    private val viewModelCache = mutableMapOf<Class<out AndroidViewModel>, AndroidViewModel>()

    private fun <T : AndroidViewModel> getViewModel(viewModelClass: Class<T>): T {

        val cachedViewModel = viewModelCache[viewModelClass]

        // El operador ?.let es para verificar si el valor en el caché no es null antes de hacer el cast.
        // Si el valor no es null, realizamos el cast seguro con as T.
        // Esto evita el error de compilación y el ClassCastException.
        cachedViewModel?.let {
            @Suppress("UNCHECKED_CAST")
            return it as T
        }

        val viewModelStoreOwner = context as? ViewModelStoreOwner
            ?: throw IllegalArgumentException("Context must be a ViewModelStoreOwner")

        val viewModel = ViewModelProvider(viewModelStoreOwner)[viewModelClass]

        viewModelCache[viewModelClass] = viewModel

        return viewModel
    }


    val loginViewModel: LoginViewModel by lazy {
        getViewModel(LoginViewModel::class.java)
    }

    val registerViewModel: RegisterViewModel by lazy {
        getViewModel(RegisterViewModel::class.java)
    }

    val homeViewModel: HomeViewModel by lazy {
        getViewModel(HomeViewModel::class.java)
    }
}
