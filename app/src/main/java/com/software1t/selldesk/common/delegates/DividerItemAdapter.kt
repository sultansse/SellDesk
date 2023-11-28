package com.software1t.selldesk.common.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.common.model.DividerAdapterModel
import com.software1t.selldesk.databinding.DelegateDividerBinding

class DividerItemAdapter :
    DelegateAdapter<DividerAdapterModel, DelegateDividerBinding, DividerItemAdapter.DividerItemViewHolder>(
        DividerAdapterModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<DividerAdapterModel, DelegateDividerBinding> {
        val binding = DelegateDividerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DividerItemViewHolder(binding = binding)
    }

    class DividerItemViewHolder(
        private val binding: DelegateDividerBinding,
    ) : BaseViewHolder<DividerAdapterModel, DelegateDividerBinding>(binding) {
        override fun bind() {
            getRowItem()?.let { model ->
                binding.divider.isVisible = model.isVisible
            }
        }
    }
}