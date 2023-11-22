package com.software1t.selldesk.data.mapper

import android.annotation.SuppressLint
import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.common.extenshions.tenge
import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.domain.model.CarDomainModel
import java.text.SimpleDateFormat
import java.util.Locale

@SuppressLint("SimpleDateFormat")
class CarDataDomainMapper : Mapper<CarDataModel, CarDomainModel> {

    private val DATE_FORMAT = "yyyy-MM-dd"
    private val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())

    private fun extractDigitsFromString(inputString: String): Int {
        val regex = Regex("""\d+""")
        val matchResult = regex.find(inputString)
        val digitsOnly = matchResult?.value ?: "0" // Default to "0" if no match is found
        return digitsOnly.toInt()
    }

    override fun from(i: CarDataModel): CarDomainModel {
        return CarDomainModel(
            id = i.id,
            name = i.name,
            price = "${i.price} $tenge",
            image = i.image,
            description = i.description,
            city = i.city,
            isLiked = i.isLiked,
            postDate = formatter.parse(i.postDate) ?: formatter.parse("2000-01-01"),
            postViewedCount = i.postViewedCount,
            postLikedCount = i.postLikedCount,
        )
    }

    override fun to(o: CarDomainModel): CarDataModel {
        return CarDataModel(
            id = o.id,
            name = o.name,
            price = extractDigitsFromString(o.price),
            image = o.image,
            description = o.description,
            city = o.city,
            isLiked = o.isLiked,
            postDate = formatter.format(o.postDate),
            postViewedCount = o.postViewedCount,
            postLikedCount = o.postLikedCount,
        )
    }
}