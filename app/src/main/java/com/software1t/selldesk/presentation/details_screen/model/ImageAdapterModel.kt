package com.software1t.selldesk.presentation.details_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel
import com.software1t.selldesk.common.model.DividerAdapterModel

class ImageAdapterModel(
    val carImage: Int,
) : DelegateAdapterModel {

    override fun id(): Any = DividerAdapterModel::class.toString()

    override fun content(): Any = DividerAdapterModelContent(
        carImage = carImage,
    )

    inner class DividerAdapterModelContent(
        val carImage: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is DividerAdapterModelContent) {
                return carImage == other.carImage
            }
            return false
        }

        override fun hashCode(): Int {
            var result = carImage.hashCode()
            result = 31 * result + carImage.hashCode()
            return result
        }
    }
}