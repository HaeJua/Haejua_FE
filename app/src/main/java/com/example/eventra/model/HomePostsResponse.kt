package com.example.eventra.model

data class HomePostsResponse(
    val club: List<Post>,
    val official: List<Post>,
    val department: List<Post>,
)