package com.example.eventra.network

import com.example.eventra.model.HomePostsResponse
import com.example.eventra.model.PostDetailResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostApi {
    @GET("detail/{postId}")
    suspend fun getPostDetail(
        @Path("postId") postId: Int
    ): PostDetailResponse
}