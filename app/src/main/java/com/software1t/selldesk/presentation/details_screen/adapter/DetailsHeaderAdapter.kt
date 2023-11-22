package com.software1t.selldesk.presentation.details_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.databinding.DelegateDetailsHeaderBinding
import com.software1t.selldesk.presentation.details_screen.model.DetailsUiModel

class DetailsHeaderAdapter :
    DelegateAdapter<DetailsUiModel, DelegateDetailsHeaderBinding, DetailsHeaderAdapter.HeaderViewHolder>(
        DetailsUiModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<DetailsUiModel, DelegateDetailsHeaderBinding> {
        val binding = DelegateDetailsHeaderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HeaderViewHolder(binding = binding)
    }

    class HeaderViewHolder(
        private val binding: DelegateDetailsHeaderBinding,
    ) : BaseViewHolder<DetailsUiModel, DelegateDetailsHeaderBinding>(binding) {

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    tvCarName.text = "it.name"
                    tvCarPrice.text = "it.price"
                }
            }
        }
    }
}