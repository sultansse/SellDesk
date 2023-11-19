package com.software1t.selldesk.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.software1t.selldesk.base.BaseRecyclerAdapter
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.databinding.GridTableItemBinding
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel


class CategoryAdapter (
    private val clickFunc : (() -> Unit)? = null
) : BaseRecyclerAdapter<CategoryUiModel, GridTableItemBinding, CategoryAdapter.CategoryViewHolder>(CategoryItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = GridTableItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding = binding, click = clickFunc)
    }

    class CategoryViewHolder(
        private val binding : GridTableItemBinding,
        private val click : (() -> Unit)? = null
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

class CategoryItemDiffUtil : DiffUtil.ItemCallback<CategoryUiModel>() {
    override fun areItemsTheSame(oldItem: CategoryUiModel, newItem: CategoryUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryUiModel, newItem: CategoryUiModel): Boolean {
        return oldItem == newItem
    }
}