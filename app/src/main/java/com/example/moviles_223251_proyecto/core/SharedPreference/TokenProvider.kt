package com.example.moviles_223251_proyecto.core.SharedPreference

import android.content.Context
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.appDatabase.AppDatabase
import com.example.moviles_223251_proyecto.core.data.repository.users.UserRepository
import kotlinx.coroutines.runBlocking

class TokenProvider(context: Context) {

    private val userDAO = AppDatabase.getDatabase(context).userDao()
    private val userPreferences = UserPreferences(context)
    private val userRepository = UserRepository(userPreferences, userDAO)

    fun getToken(): String? {
        return runBlocking {
            val userId = userRepository.getUserId() ?: return@runBlocking null
            val user = userDAO.getUserById(userId)
            user?.token ?: ""
        }
    }

    fun clearToken() {
        runBlocking {
            val userId = userRepository.getUserId()
            userRepository.logout()
            if (userId != null) {
                val user = userDAO.getUserById(userId)
                if (user != null) {
                    userDAO.deleteUser(userId) // Elimina el usuario de la base de datos
                }
            }
        }
    }
}