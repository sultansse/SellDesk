package com.software1t.selldesk.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.software1t.selldesk.R
import com.software1t.selldesk.common.extenshions.setAttrs
import com.software1t.selldesk.databinding.ViewSquareLinearLayoutBinding

class SquareLinearLayoutView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val squareBinding: ViewSquareLinearLayoutBinding =
        ViewSquareLinearLayoutBinding.inflate(LayoutInflater.from(context), this)

    var rootClick: (() -> Unit)? = null

    init {
        setAttrs(attrs, R.styleable.SquareLinearLayoutView) {
            squareBinding.ivIcon.setImageResource(
                it.getResourceId(
                    R.styleable.SquareLinearLayoutView_src_icon,
                    R.drawable.ic_launcher_app
                )
            )
            squareBinding.tvTitle.text =
                it.getString(R.styleable.SquareLinearLayoutView_category_title)
        }

        squareBinding.root.setOnClickListener {
            rootClick?.invoke()
        }
    }
}