package com.software1t.selldesk.base.adapter

import androidx.recyclerview.widget.DiffUtil


internal class DelegateAdapterItemDiffCallback : DiffUtil.ItemCallback<DelegateAdapterModel>() {

    override fun areItemsTheSame(
        oldItem: DelegateAdapterModel, newItem: DelegateAdapterModel
    ): Boolean = oldItem::class == newItem::class && oldItem.id() == newItem.id()


    override fun areContentsTheSame(
        oldItem: DelegateAdapterModel, newItem: DelegateAdapterModel
    ): Boolean = oldItem.content() == newItem.content()
}
