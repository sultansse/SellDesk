package com.software1t.selldesk.domain.model

import java.util.Date

data class CarDomainModel(
    val id: Int,
    val name: String,
    val price: String,
    val image: Int,
    val description: String,
    val city: String,
    val isLiked: Boolean,
    val postDate: Date,
    val postViewedCount: Long,
    val postLikedCount: Long,
)
/* : Mappable<CarUiModel> {

 val UI_DATE_FORMAT = "dd MMMM yyyy"
 val outputFormatter = SimpleDateFormat(UI_DATE_FORMAT, Locale.getDefault())

 override fun map() = CarUiModel(
     id = id,
     name = name,
     price = price,
     image = image,
     description = description,
     city = city,
     isLiked = isLiked,
     postDate = outputFormatter.format(postDate),
     postViewedCount = postViewedCount,
     postLikedCount = postLikedCount,
 )
}*/