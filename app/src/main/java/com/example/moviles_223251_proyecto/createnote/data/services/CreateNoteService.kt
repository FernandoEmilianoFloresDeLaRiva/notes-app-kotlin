package com.example.moviles_223251_proyecto.createnote.data.services

import com.example.moviles_223251_proyecto.core.data.api.RetroFitClient
import com.example.moviles_223251_proyecto.core.domain.adapters.ErrorResponse
import com.example.moviles_223251_proyecto.createnote.data.api.CreateNoteApi
import com.example.moviles_223251_proyecto.createnote.domain.adapters.CreateNoteResponseAdapter
import com.example.moviles_223251_proyecto.createnote.domain.dtos.CreateNoteDto
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateNoteService {
    private val createNoteApi = RetroFitClient.createService(CreateNoteApi::class.java)

    suspend fun createNote(reqNote : CreateNoteDto) : Result<CreateNoteResponseAdapter> {
        return withContext(Dispatchers.IO){
            try {
                val response = createNoteApi.createNote(reqNote)
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        Result.success(body)
                    }else{
                        Result.failure(Exception("Empty response body"))
                    }
                }else{
                    val errorBody = response.errorBody()?.string()
                    val errorResponse = try {
                        Gson().fromJson(errorBody, ErrorResponse::class.java)
                    } catch (e: Exception) {
                        null
                    }
                    val resError = errorResponse?.message ?: "Error: ${response.code()} - ${response.message()}"
                    Result.failure(Exception(resError))
                }
            }catch (e : Exception){
                Result.failure(e)
            }
        }
    }
}