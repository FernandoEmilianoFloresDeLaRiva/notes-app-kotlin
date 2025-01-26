package com.example.moviles_223251_proyecto.register.data.api

import com.example.moviles_223251_proyecto.core.domain.constants.ApiConfig
import com.example.moviles_223251_proyecto.register.domain.adapters.RegisterResponseAdapter
import com.example.moviles_223251_proyecto.register.domain.dtos.RegisterUserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST(ApiConfig.API_USERS)
    suspend fun register(@Body registerRequest : RegisterUserDto) : Response<RegisterResponseAdapter>
}