package com.software1t.selldesk.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.software1t.selldesk.R
import com.software1t.selldesk.common.extenshions.setAttrs
import com.software1t.selldesk.databinding.ViewToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this)

    var likeClick: (() -> Unit)? = null
    var shareClick: (() -> Unit)? = null

    init {
        setAttrs(attrs, R.styleable.ToolbarView) {

            with(binding) {
                title.text = it.getString(R.styleable.ToolbarView_toolbar_title)
                backBtn.isVisible =
                    it.getBoolean(R.styleable.ToolbarView_toolbar_back_btn_visibility, false)
                likeBtn.isVisible =
                    it.getBoolean(R.styleable.ToolbarView_toolbar_like_btn_visibility, false)
                shareBtn.isVisible =
                    it.getBoolean(R.styleable.ToolbarView_toolbar_share_btn_visibility, false)


                shareBtn.setOnClickListener {
                    shareClick?.invoke()
                }
                likeBtn.setOnClickListener {
                    likeClick?.invoke()
                }
                backBtn.setOnClickListener {
                    findNavController().popBackStack()
                }
            }

        }
    }
}