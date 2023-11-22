package com.software1t.selldesk.common.extenshions

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Any?.isNull() = this == null
fun Any?.isNotNull() = this != isNull()

val String.Companion.empty get() = ""
const val tenge = "₸"

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

//Context
fun Context.vibratePhone() {
    val vibration = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        vibration.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibration.vibrate(100)
    }
}