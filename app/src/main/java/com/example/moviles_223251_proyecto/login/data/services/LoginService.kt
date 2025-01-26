package com.example.moviles_223251_proyecto.login.data.services

import com.example.moviles_223251_proyecto.core.data.api.RetroFitClient
import com.example.moviles_223251_proyecto.login.data.api.LoginApi
import com.example.moviles_223251_proyecto.login.domain.adapters.TokenResponseAdapter
import com.example.moviles_223251_proyecto.login.domain.dtos.LoginUserDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val loginService = RetroFitClient.createService(LoginApi::class.java)

    suspend fun login(reqLogin: LoginUserDto): Result<TokenResponseAdapter> {
        return withContext(Dispatchers.IO) {
            try {
                val response = loginService.login(reqLogin)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        Result.success(body)
                    } else {
                        Result.failure(Exception("Empty response body"))
                    }
                } else {
                    Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}