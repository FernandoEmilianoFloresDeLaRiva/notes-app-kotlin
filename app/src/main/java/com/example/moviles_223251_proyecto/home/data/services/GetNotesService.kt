package com.example.moviles_223251_proyecto.home.data.services

import com.example.moviles_223251_proyecto.core.data.api.RetroFitClient
import com.example.moviles_223251_proyecto.core.domain.adapters.ErrorResponse
import com.example.moviles_223251_proyecto.home.data.api.GetNotesApi
import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNotesService {
    private val getNotesService = RetroFitClient.createService(GetNotesApi::class.java)

    suspend fun getNotesService(userId : Int) : Result<List<NoteResponseAdapter>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = getNotesService.getNotes(id = userId)
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