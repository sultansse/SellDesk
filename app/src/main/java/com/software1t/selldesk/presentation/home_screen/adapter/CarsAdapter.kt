package com.software1t.selldesk.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.software1t.selldesk.R
import com.software1t.selldesk.base.BaseRecyclerAdapter
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.databinding.ItemCarBinding
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class CarsAdapter (
    private val clickFunc : (() -> Unit)? = null
) : BaseRecyclerAdapter<CarUiModel, ItemCarBinding, CarsAdapter.CarViewHolder>(CarItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarViewHolder(binding = binding, click = clickFunc)
    }

    class CarViewHolder (
        private val binding : ItemCarBinding,
        private val click : (() -> Unit)? = null
    ) : BaseViewHolder<CarUiModel, ItemCarBinding>(binding) {

        init {
            binding.root.setOnClickListener {
                click?.invoke()
            }
        }

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    tvCarName.text = it.name
                    tvPrice.text = it.price
                    ivCarImage.setImageResource(it.image)
                    tvCarDescription.text = it.description
                    tvCarCity.text = it.city
                    ivLikesIcon.setImageResource(if (it.isLiked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outlined)
                    tvPostedAt.text = it.postDate.toString()
                    tvViewsCount.text = it.postViewedCount.toString()
                    tvLikesCount.text = it.postLikedCount.toString()
                }
            }
        }
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