package com.example.moviles_223251_proyecto.core.data.api.interceptors

import com.example.moviles_223251_proyecto.core.SharedPreference.TokenProvider
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val tokenProvider: TokenProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val nonProtectedEndpoints = listOf("/users")

        val notNeedsAuth = nonProtectedEndpoints.any { endpoint ->
            request.url.encodedPath.contains(endpoint)
        }

        return if (notNeedsAuth){
            chain.proceed(request)
        }else{
            val token = tokenProvider.getToken()
            if (!token.isNullOrEmpty()) {
                val authenticatedRequest = request.newBuilder()
                    .addHeader("authorization", "Bearer $token")
                    .build()
                chain.proceed(authenticatedRequest)
            } else {
                chain.proceed(request)
            }
        }
    }
}