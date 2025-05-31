package com.example.eventra.model

import java.util.Date

data class PostDetailResponse(
    val id: Int,
    val title: String,
    val image: List<String>,
    val duration: String,
    val target: String,
    val notice: String,
)