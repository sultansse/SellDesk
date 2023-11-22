package com.software1t.selldesk.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.software1t.selldesk.common.constants.Constants.Companion.CARS_TABLE

@Entity(tableName = CARS_TABLE)
data class CarLocalModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String?,
    val price: Int?,
    val image: Int?,
    val description: String?,
    val city: String?,
    val isLiked: Boolean?,
    val postDate: String?,
    val postViewedCount: Long?,
    val postLikedCount: Long?,
)
/* : Mappable<CarDataModel> {

 override fun map() = CarDataModel(
     id = id,
     name = name  ?: String.empty,
     price = price ?: 0,
     image = image ?: 0,
     description = description ?: String.empty,
     city = city ?: String.empty,
     isLiked = isLiked ?: false,
     postDate = postDate ?: String.empty,
     postViewedCount = postViewedCount ?: 0,
     postLikedCount = postLikedCount ?: 0,
 )
}*/