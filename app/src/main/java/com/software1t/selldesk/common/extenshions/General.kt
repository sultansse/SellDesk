package com.software1t.selldesk.common.extenshions

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Any?.isNull() = this == null
fun Any?.isNotNull() = this != isNull()


//View
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

//Fragment
fun Fragment.navigate(direction: NavDirections) {
    try {
        findNavController().navigate(direction)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}