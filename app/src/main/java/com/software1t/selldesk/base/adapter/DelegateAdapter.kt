package com.software1t.selldesk.base.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.software1t.selldesk.base.BaseViewHolder

/**
 * Base Adapter class for RecyclerView
 */
abstract class DelegateAdapter<DelegateAdapterModel : Any, VB : ViewBinding, VH : BaseViewHolder<DelegateAdapterModel, VB>>(val modelClass: Class<out DelegateAdapterModel>) {

    abstract fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<DelegateAdapterModel, VB>
    fun onBindViewHolder(holder: VH, model: DelegateAdapterModel) {
        holder.doBindings(model)
        holder.bind()
    }

    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}