package com.example.moviles_223251_proyecto.login.data.services

import com.example.moviles_223251_proyecto.core.data.api.RetroFitClient
import com.example.moviles_223251_proyecto.core.domain.adapters.ErrorResponse
import com.example.moviles_223251_proyecto.login.data.api.LoginApi
import com.example.moviles_223251_proyecto.login.domain.adapters.TokenResponseAdapter
import com.example.moviles_223251_proyecto.login.domain.dtos.LoginUserDto
import com.google.gson.Gson
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
                    val errorBody = response.errorBody()?.string()
                    val errorResponse = try {
                        // Aquí usamos Gson para deserializar el cuerpo de error
                        Gson().fromJson(errorBody, ErrorResponse::class.java)
                    } catch (e: Exception) {
                        null
                    }
                    val resError = errorResponse?.message ?: "Error: ${response.code()} - ${response.message()}"
                    Result.failure(Exception(resError))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}