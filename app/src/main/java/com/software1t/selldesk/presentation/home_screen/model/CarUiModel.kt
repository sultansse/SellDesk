package com.software1t.selldesk.presentation.home_screen.model

import java.util.Date

data class CarUiModel(
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