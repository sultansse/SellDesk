package com.software1t.selldesk.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.software1t.selldesk.R
import com.software1t.selldesk.common.extenshions.setAttrs
import com.software1t.selldesk.databinding.ViewSquareLinearLayoutBinding

class SquareLinearLayoutView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val squareBinding: ViewSquareLinearLayoutBinding = ViewSquareLinearLayoutBinding.inflate(LayoutInflater.from(context), this, false)

    var rootClick: (() -> Unit)? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    init {
        setAttrs(attrs, R.styleable.ToolbarView) {
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