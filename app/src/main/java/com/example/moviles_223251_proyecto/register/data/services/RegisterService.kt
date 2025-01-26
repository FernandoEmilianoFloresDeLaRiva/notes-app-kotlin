package com.example.moviles_223251_proyecto.register.data.services

import com.example.moviles_223251_proyecto.core.data.api.RetroFitClient
import com.example.moviles_223251_proyecto.core.domain.adapters.ErrorResponse
import com.example.moviles_223251_proyecto.register.data.api.RegisterApi
import com.example.moviles_223251_proyecto.register.domain.adapters.RegisterResponseAdapter
import com.example.moviles_223251_proyecto.register.domain.dtos.RegisterUserDto
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterService {
    private val registerService = RetroFitClient.createService(RegisterApi::class.java)

    suspend fun register(reqRegister : RegisterUserDto) : Result<RegisterResponseAdapter> {
        return withContext(Dispatchers.IO) {
            try {
                val response = registerService.register(reqRegister)
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