package com.software1t.selldesk.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.software1t.selldesk.R
import com.software1t.selldesk.common.extenshions.setAttrs
import com.software1t.selldesk.databinding.ViewToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this)

    var backClick: (() -> Unit)? = null
    var newsClick: (() -> Unit)? = null

    init {
        setAttrs(attrs, R.styleable.ToolbarView) {
            binding.title.text = it.getString(R.styleable.ToolbarView_toolbar_title)
            binding.backBtn.isVisible =
                it.getBoolean(R.styleable.ToolbarView_toolbar_back_btn_visibility, false)
        }

        binding.backBtn.setOnClickListener {
            backClick?.invoke()
        }

        binding.newsBtn.setOnClickListener {
            newsClick?.invoke()
        }
    }
}
