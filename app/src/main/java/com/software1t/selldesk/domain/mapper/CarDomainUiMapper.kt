package com.software1t.selldesk.domain.mapper

import android.annotation.SuppressLint
import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.domain.model.CarDomainModel
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import java.text.SimpleDateFormat
import java.util.Locale

@SuppressLint("SimpleDateFormat")
class CarDomainUiMapper : Mapper<CarDomainModel, CarUiModel> {

    private val DATE_FORMAT = "dd MMMM yyyy"
    private val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())

    override fun from(i: CarDomainModel): CarUiModel {
        return CarUiModel(
            id = i.id,
            name = i.name,
            price = i.price,
            image = i.image,
            description = i.description,
            city = i.city,
            isLiked = i.isLiked,
            postDate = formatter.format(i.postDate),
            postViewedCount = i.postViewedCount,
            postLikedCount = i.postLikedCount,
        )
    }

    override fun to(o: CarUiModel): CarDomainModel {
        return CarDomainModel(
            id = o.id,
            name = o.name,
            price = o.price,
            image = o.image,
            description = o.description,
            city = o.city,
            isLiked = o.isLiked,
            postDate = formatter.parse(o.postDate)!!,
            postViewedCount = o.postViewedCount,
            postLikedCount = o.postLikedCount,
        )
    }
}