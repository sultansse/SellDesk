package com.software1t.selldesk.presentation.details_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.databinding.DelegateDetailsHeaderBinding
import com.software1t.selldesk.presentation.details_screen.model.HeaderAdapterModel

class DetailsHeaderAdapter :
    DelegateAdapter<HeaderAdapterModel, DelegateDetailsHeaderBinding, DetailsHeaderAdapter.HeaderViewHolder>(
        HeaderAdapterModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<HeaderAdapterModel, DelegateDetailsHeaderBinding> {
        val binding = DelegateDetailsHeaderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HeaderViewHolder(binding = binding)
    }

    class HeaderViewHolder(
        private val binding: DelegateDetailsHeaderBinding,
    ) : BaseViewHolder<HeaderAdapterModel, DelegateDetailsHeaderBinding>(binding) {

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    tvCarName.text = it.carName
                    tvCarPrice.text = it.carPrice
                }
            }
        }
    }
}