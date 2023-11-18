package com.software1t.selldesk.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.software1t.selldesk.base.BaseRecyclerAdapter
import com.software1t.selldesk.databinding.CarItemBinding
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class CarsAdapter (
    private val clickFunc : (() -> Unit)? = null
) : BaseRecyclerAdapter<CarUiModel, CarItemBinding, CarViewHolder>(CarItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = CarItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarViewHolder(binding = binding, click = clickFunc)
    }
}

class CarItemDiffUtil : DiffUtil.ItemCallback<CarUiModel>() {
    override fun areItemsTheSame(oldItem: CarUiModel, newItem: CarUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarUiModel, newItem: CarUiModel): Boolean {
        return oldItem == newItem
    }
}