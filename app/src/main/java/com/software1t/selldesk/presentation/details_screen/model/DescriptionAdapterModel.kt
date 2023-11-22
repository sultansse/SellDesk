package com.software1t.selldesk.presentation.details_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class DescriptionAdapterModel(
    val city: String,
    val generation: String,
    val mileage: String,
    val transmission: String,
    val drive: String,
) : DelegateAdapterModel {

    override fun id(): Any = DividerAdapterModel::class.toString()

    override fun content(): Any = DividerAdapterModelContent(
        city = city,
        generation = generation,
        mileage = mileage,
        transmission = transmission,
        drive = drive,
    )

    inner class DividerAdapterModelContent(
        val city: String,
        val generation: String,
        val mileage: String,
        val transmission: String,
        val drive: String,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is DividerAdapterModelContent) {
                return city == other.city && generation == other.generation && mileage == other.mileage && transmission == other.transmission && drive == other.drive
            }
            return false
        }

        override fun hashCode(): Int {
            var result = city.hashCode()
            result = 31 * result + city.hashCode()
            return result
        }
    }
}