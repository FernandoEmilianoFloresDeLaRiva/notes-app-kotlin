package com.example.moviles_223251_proyecto.createnote.data.api

import com.example.moviles_223251_proyecto.core.domain.constants.ApiConfig
import com.example.moviles_223251_proyecto.createnote.domain.adapters.CreateNoteResponseAdapter
import com.example.moviles_223251_proyecto.createnote.domain.dtos.CreateNoteDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateNoteApi {
    @POST(ApiConfig.API_NOTES)
    suspend fun createNote(@Body createNoteDto: CreateNoteDto) : Response<CreateNoteResponseAdapter>
}