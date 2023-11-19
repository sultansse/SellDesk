package com.software1t.selldesk.base.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.software1t.selldesk.base.BaseViewHolder

@Suppress("UNCHECKED_CAST")
class CompositeAdapter(
    private val delegates: SparseArray<DelegateAdapter<DelegateAdapterModel, ViewBinding, BaseViewHolder<DelegateAdapterModel, ViewBinding>>>
) : ListAdapter<DelegateAdapterModel, BaseViewHolder<DelegateAdapterModel, ViewBinding>>(
    DelegateAdapterItemDiffCallback()
) {

    override fun getItemViewType(position: Int): Int {
        for (i in 0 until delegates.size()) {
            if (delegates[i].modelClass == getItem(position).javaClass) {
                return delegates.keyAt(i)
            }
        }
        throw NullPointerException("Can not get viewType for position $position")
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BaseViewHolder<DelegateAdapterModel, ViewBinding> =
        delegates[viewType].onCreateViewHolder(parent)

    override fun onBindViewHolder(
        holder: BaseViewHolder<DelegateAdapterModel, ViewBinding>,
        position: Int,
    ) {
        val delegateAdapter = delegates[getItemViewType(position)]

        if (delegateAdapter != null) {
            delegateAdapter.onBindViewHolder(
                holder,
                getItem(position)
            ) // need to check model is ok or need position as int
        } else {
            throw NullPointerException("can not find adapter for position $position")
        }
    }

    override fun onViewRecycled(holder: BaseViewHolder<DelegateAdapterModel, ViewBinding>) {
        delegates[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<DelegateAdapterModel, ViewBinding>) {
        delegates[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<DelegateAdapterModel, ViewBinding>) {
        delegates[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }

    override fun submitList(items: List<DelegateAdapterModel>?) {
        super.submitList(items ?: emptyList())
    }

    class Builder {

        private var count: Int = 0
        private val delegates: SparseArray<DelegateAdapter<DelegateAdapterModel, ViewBinding, BaseViewHolder<DelegateAdapterModel, ViewBinding>>> =
            SparseArray()

        fun add(delegateAdapter: DelegateAdapter<out DelegateAdapterModel, out ViewBinding, out BaseViewHolder<out DelegateAdapterModel, out ViewBinding>>): Builder {
            delegates.put(
                count++,
                delegateAdapter as DelegateAdapter<DelegateAdapterModel, ViewBinding, BaseViewHolder<DelegateAdapterModel, ViewBinding>>
            )
            return this
        }

        fun build(): CompositeAdapter {
            require(count != 0) { "Register at least one adapter" }
            return CompositeAdapter(delegates)
        }
    }
}