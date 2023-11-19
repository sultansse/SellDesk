package com.software1t.selldesk.presentation.home_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

data class CategoryUiModel (
    val id: Int,
    val label: String,
    val image: Int,
) : DelegateAdapterModel {
    override fun id(): Any = id

    override fun content(): Any = this
}