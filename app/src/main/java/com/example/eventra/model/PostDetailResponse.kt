package com.example.eventra.model

import java.util.Date

data class PostDetailResponse(
    val id: Int,
    val title: String,
    val image: List<String>,
    val duration: Date,
    val target: String,
    val benefit: String,
    val notice: String,
)