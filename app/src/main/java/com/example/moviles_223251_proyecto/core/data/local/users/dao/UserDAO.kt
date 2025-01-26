package com.example.moviles_223251_proyecto.core.data.local.users.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviles_223251_proyecto.core.data.local.users.entities.User

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE id = :userId LIMIT 1")
    suspend fun getUserById(userId: Int): User?

    @Query("UPDATE users SET token = :token WHERE id = :userId")
    suspend fun updateUserToken(userId: Int, token: String)
}