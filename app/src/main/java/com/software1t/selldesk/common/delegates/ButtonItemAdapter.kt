package com.software1t.selldesk.common.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.common.model.ButtonAdapterModel
import com.software1t.selldesk.databinding.DelegateButtonBinding

class ButtonItemAdapter :
    DelegateAdapter<ButtonAdapterModel, DelegateButtonBinding, ButtonItemAdapter.ButtonItemViewHolder>(
        ButtonAdapterModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<ButtonAdapterModel, DelegateButtonBinding> {
        val binding = DelegateButtonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ButtonItemViewHolder(binding = binding)
    }

    inner class ButtonItemViewHolder(
        private val binding: DelegateButtonBinding,
    ) : BaseViewHolder<ButtonAdapterModel, DelegateButtonBinding>(binding) {

        override fun bind() {
            getRowItem()?.let { model ->
                with(binding.btn) {
                    text = model.text
                    isEnabled = model.isEnabled

                    setOnClickListener {
                        model.btnClick?.invoke()
                    }
                }
            }
        }
    }
}