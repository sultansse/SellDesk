package com.software1t.selldesk.common.model

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class ButtonAdapterModel(
    val isEnabled: Boolean = true,
    val text: String,
    val btnClick: (() -> Unit)? = null,
) : DelegateAdapterModel {

    override fun id(): Any = ButtonAdapterModel::class.toString()

    override fun content(): Any = ButtonAdapterModelContent(
        isEnabled = isEnabled,
        text = text,
    )

    inner class ButtonAdapterModelContent(
        val isEnabled: Boolean,
        val text: String,
    ) {
        override fun equals(other: Any?): Boolean {
            if (other is ButtonAdapterModelContent) {
                return text == other.text && isEnabled == other.isEnabled
            }
            return false
        }

        override fun hashCode(): Int {
            var result = text.hashCode()
            result = 31 * result + text.hashCode()
            return result
        }
    }
}