package com.software1t.selldesk.local.mapper

import android.annotation.SuppressLint
import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.common.extenshions.empty
import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.local.model.CarLocalModel
import java.text.SimpleDateFormat
import java.util.Locale


@SuppressLint("SimpleDateFormat")
class CarLocalDataMapper : Mapper<CarLocalModel, CarDataModel> {

    private val DATE_FORMAT = "yyyy-MM-dd"
    private val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())

    private fun extractDigitsFromString(inputString: String): Int {
        val regex = Regex("""\d+""")
        val matchResult = regex.find(inputString)
        val digitsOnly = matchResult?.value ?: "0" // Default to "0" if no match is found
        return digitsOnly.toInt()
    }

    override fun from(i: CarLocalModel): CarDataModel {
        return CarDataModel(
            id = i.id,
            name = i.name ?: String.empty,
            price = i.price ?: 0,
            image = i.image ?: 0,
            description = i.description ?: String.empty,
            city = i.city ?: String.empty,
            isLiked = i.isLiked ?: false,
            postDate = i.postDate ?: String.empty,
            postViewedCount = i.postViewedCount ?: 0L,
            postLikedCount = i.postLikedCount ?: 0L,
        )
    }

    override fun to(o: CarDataModel): CarLocalModel {
        return CarLocalModel(
            id = o.id,
            name = o.name,
            price = o.price,
            image = o.image,
            description = o.description,
            city = o.city,
            isLiked = o.isLiked,
            postDate = o.postDate,
            postViewedCount = o.postViewedCount,
            postLikedCount = o.postLikedCount,
        )
    }
}