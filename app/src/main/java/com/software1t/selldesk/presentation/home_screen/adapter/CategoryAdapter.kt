package com.software1t.selldesk.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.software1t.selldesk.R
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapterModel
import com.software1t.selldesk.databinding.GridTableItemBinding
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel


class CategoryAdapter(
    private val clickFunc: (() -> Unit)? = null
) : DelegateAdapter<CategoryUiModel, GridTableItemBinding, CategoryAdapter.CategoryViewHolder>(CategoryUiModel::class.java) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<CategoryUiModel, GridTableItemBinding> {
        val binding =
            GridTableItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding = binding, click = clickFunc)
    }

    class CategoryViewHolder(
        private val binding: GridTableItemBinding, private val click: (() -> Unit)? = null
    ) : BaseViewHolder<CategoryUiModel, GridTableItemBinding>(binding) {

        init {
            binding.root.setOnClickListener {
                click?.invoke()
            }
        }

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    ivIcon.setImageResource(it.image)
                    tvLabel.text = it.label
                }
            }
        }
    }
}