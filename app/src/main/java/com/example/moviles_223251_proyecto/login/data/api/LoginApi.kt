package com.example.moviles_223251_proyecto.login.data.api

import com.example.moviles_223251_proyecto.core.domain.constants.ApiConfig
import com.example.moviles_223251_proyecto.login.domain.adapters.TokenResponseAdapter
import com.example.moviles_223251_proyecto.login.domain.dtos.LoginUserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("${ApiConfig.API_USERS}login/")
    suspend fun login(@Body loginRequest: LoginUserDto): Response<TokenResponseAdapter>
}