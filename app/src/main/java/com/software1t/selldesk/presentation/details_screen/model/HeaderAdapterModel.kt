package com.software1t.selldesk.presentation.details_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class HeaderAdapterModel(
    val carName: String,
    val carPrice: String,
) : DelegateAdapterModel {

    override fun id(): Any = DividerAdapterModel::class.toString()

    override fun content(): Any = DividerAdapterModelContent(
        carName = carName,
        carPrice = carPrice,
    )

    inner class DividerAdapterModelContent(
        val carName: String,
        val carPrice: String,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is DividerAdapterModelContent) {
                return carName == other.carName && carPrice == other.carPrice
            }
            return false
        }

        override fun hashCode(): Int {
            var result = carName.hashCode()
            result = 31 * result + carPrice.hashCode()
            return result
        }
    }
}