package com.example.moviles_223251_proyecto.core.data.repository.users

import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.users.dao.UserDAO
import com.example.moviles_223251_proyecto.core.data.local.users.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(
    private val userPreferences: UserPreferences,
    private val userDao: UserDAO
) {

    suspend fun saveUserId(userId: Int) {
        withContext(Dispatchers.IO) {
            userPreferences.saveUserId(userId)
        }
    }

    suspend fun getUserId(): Int? {
        return withContext(Dispatchers.IO) {
            userPreferences.getUserId()?.toInt()
        }
    }

    suspend fun saveUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    suspend fun getUser(userId: Int): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUserById(userId)
        }
    }

    suspend fun logout() {
        withContext(Dispatchers.IO) {
            userPreferences.clearUserId()
        }
    }
}