package com.example.moviles_223251_proyecto.home.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.appDatabase.AppDatabase
import com.example.moviles_223251_proyecto.core.data.repository.users.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel(app : Application) : AndroidViewModel(app) {

    private val userDAO = AppDatabase.getDatabase(app).userDao()
    private val userPreferences = UserPreferences(app)
    private val userRepository = UserRepository(userPreferences, userDAO)

    init {
        getNotes()
    }

    private fun getNotes () {
        viewModelScope.launch {
            val userId = userRepository.getUserId() ?: 0
            val user = userRepository.getUser(userId)
            val token = user?.token ?: ""
        }
    }
}