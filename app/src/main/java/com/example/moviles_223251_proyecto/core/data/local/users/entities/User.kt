package com.example.moviles_223251_proyecto.core.data.local.users.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val username: String,
    val email: String,
    val token: String
)