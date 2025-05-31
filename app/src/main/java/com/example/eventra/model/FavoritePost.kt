package com.example.eventra.model

import java.io.Serializable

data class FavoritePost(
    val postId: Int,
    val image: String,
    val title: String,
    val isFavorite: Boolean,
) : Serializable
