package com.example.eventra.model

import java.io.Serializable

data class Post(
    val postId: Int,
    val image: String,
    val title: String,
) : Serializable
