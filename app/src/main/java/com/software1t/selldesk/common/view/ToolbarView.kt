package com.software1t.selldesk.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
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

    init {
        setAttrs(attrs, R.styleable.ToolbarView) {
            with(binding.topAppBar) {


                navigationIcon.apply {
                    isVisible =
                        it.getBoolean(R.styleable.ToolbarView_toolbar_back_btn_visibility, false)
                }

                title = it.getString(R.styleable.ToolbarView_toolbar_title)

                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }

                setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.share -> {
                            // Handle edit text press
                            Toast.makeText(context, "share", Toast.LENGTH_SHORT).show()
                            true
                        }

                        R.id.favorite -> {
                            // Handle favorite icon press
                            Toast.makeText(context, "favorite", Toast.LENGTH_SHORT).show()
                            true
                        }

                        R.id.more -> {
                            // Handle more item (inside overflow menu) press
                            Toast.makeText(context, "more", Toast.LENGTH_SHORT).show()
                            true
                        }

                        else -> {
                            Toast.makeText(context, "else", Toast.LENGTH_SHORT).show()
                            false
                        }
                    }
                }

            }
        }
    }
}
