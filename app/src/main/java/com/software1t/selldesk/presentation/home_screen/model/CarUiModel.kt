package com.software1t.selldesk.presentation.home_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

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
) : DelegateAdapterModel {

    override fun id(): Any = CarUiModel::class.toString()

    override fun content(): Any = CarUiModelContent(
        id,
        name,
        price,
        image,
        description,
        city,
        isLiked,
        postDate,
        postViewedCount,
        postLikedCount,
    )

    inner class CarUiModelContent(
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
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is CarUiModelContent) {
                return id == other.id && name == other.name && price == other.price && image == other.image && description == other.description && city == other.city && isLiked == other.isLiked && postDate == other.postDate && postViewedCount == other.postViewedCount && postLikedCount == other.postLikedCount
            }
            return false
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + name.hashCode()
            return result
        }
    }
}