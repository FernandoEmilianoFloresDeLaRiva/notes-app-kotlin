package com.example.moviles_223251_proyecto.home.data.api

import com.example.moviles_223251_proyecto.core.domain.constants.ApiConfig
import com.example.moviles_223251_proyecto.home.domain.adapters.NoteResponseAdapter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetNotesApi {
    @GET("${ApiConfig.API_NOTES}{:id}")
    suspend fun getNotes(
        @Path("id") id: Int,
        @Query("archive") archive: Int,
    ): List<NoteResponseAdapter>
}