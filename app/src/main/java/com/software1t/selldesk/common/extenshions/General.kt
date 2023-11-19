package com.software1t.selldesk.common.extenshions

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View

fun Any?.isNull() = this == null
fun Any?.isNotNull() = this != isNull()

inline fun View.setAttrs(
    attrs: AttributeSet?,
    styleable: IntArray,
    crossinline body: (TypedArray) -> Unit
) {
    context.theme.obtainStyledAttributes(attrs, styleable, 0, 0)
        .apply {
            try {
                body.invoke(this)
            } finally {
                recycle()
            }
        }
}