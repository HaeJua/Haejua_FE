package com.example.eventra.network

import com.example.eventra.model.HomePostsResponse
import retrofit2.http.GET

interface HomeApi {
    @GET("home")
    suspend fun getHomePosts(): HomePostsResponse
}