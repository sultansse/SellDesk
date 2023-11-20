package com.software1t.selldesk.presentation.home_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

data class CategoryUiModel(
    val title1: String,
    val icon1: Int,
    val title2: String,
    val icon2: Int,
    val title3: String,
    val icon3: Int,
    val title4: String,
    val icon4: Int,
    val title5: String,
    val icon5: Int,
    val title6: String,
    val icon6: Int,
) : DelegateAdapterModel {

    override fun id(): Any = CategoryUiModel::class.toString()

    override fun content(): Any = CategoryUiModelContent(
        title1,
        icon1,
        title2,
        icon2,
        title3,
        icon3,
        title4,
        icon4,
        title5,
        icon5,
        title6,
        icon6,
    )

    inner class CategoryUiModelContent(
        val title1: String,
        val icon1: Int,
        val title2: String,
        val icon2: Int,
        val title3: String,
        val icon3: Int,
        val title4: String,
        val icon4: Int,
        val title5: String,
        val icon5: Int,
        val title6: String,
        val icon6: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is CategoryUiModelContent) {
                return title1 == other.title1 && icon1 == other.icon1 && title2 == other.title2 && icon2 == other.icon2 && title3 == other.title3 && icon3 == other.icon3 && title4 == other.title4 && icon4 == other.icon4 && title5 == other.title5 && icon5 == other.icon5 && title6 == other.title6 && icon6 == other.icon6
            }
            return false
        }

        override fun hashCode(): Int {
            var result = title2.hashCode()
            result = 31 * result + title1.hashCode()
            return result
        }
    }
}