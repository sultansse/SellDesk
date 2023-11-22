package com.software1t.selldesk.presentation.details_screen.model

data class DetailsUiModel(
    val id: Int,
    val name: String,
    val price: String,
    val image: Int,
    val description: String,
    val city: String,
    val isLiked: Boolean,
    val postDate: String,
    val postViewedCount: Long,
    val postLikedCount: Long,
)