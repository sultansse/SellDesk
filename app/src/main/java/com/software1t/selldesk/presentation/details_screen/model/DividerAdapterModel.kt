package com.software1t.selldesk.presentation.details_screen.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class DividerAdapterModel(
    val isVisible: Boolean,
) : DelegateAdapterModel {

    override fun id(): Any = DividerAdapterModel::class.toString()

    override fun content(): Any = DividerAdapterModelContent(
        isVisible = isVisible,
    )

    inner class DividerAdapterModelContent(
        val isVisible: Boolean,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is DividerAdapterModelContent) {
                return isVisible == other.isVisible
            }
            return false
        }

        override fun hashCode(): Int {
            var result = isVisible.hashCode()
            result = 31 * result + isVisible.hashCode()
            return result
        }
    }
}