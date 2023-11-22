package com.software1t.selldesk.presentation.details_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.databinding.DelegateDividerBinding
import com.software1t.selldesk.presentation.details_screen.model.DetailsUiModel

class DividerItemAdapter :
    DelegateAdapter<DetailsUiModel, DelegateDividerBinding, DividerItemAdapter.DividerItemViewHolder>(
        DetailsUiModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<DetailsUiModel, DelegateDividerBinding> {
        val binding = DelegateDividerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DividerItemViewHolder(binding = binding)
    }

    class DividerItemViewHolder(
        private val binding: DelegateDividerBinding,
    ) : BaseViewHolder<DetailsUiModel, DelegateDividerBinding>(binding) {
        override fun bind() {
            TODO("Not yet implemented")
        }
    }
}