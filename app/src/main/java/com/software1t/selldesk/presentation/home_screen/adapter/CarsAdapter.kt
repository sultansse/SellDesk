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
    private val clickFunc: ((Int) -> Unit)? = null
) : BaseRecyclerAdapter<CarUiModel, ItemCarBinding, CarsAdapter.CarViewHolder>(CarItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CarViewHolder(binding = binding, click = clickFunc)
    }

    class CarViewHolder (
        private val binding : ItemCarBinding,
        private val click: ((Int) -> Unit)? = null
    ) : BaseViewHolder<CarUiModel, ItemCarBinding>(binding) {

        init {
            binding.root.setOnClickListener {
                getRowItem()?.let {
                    click?.invoke(it.id)
                }

            }
        }

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    tvCarName.text = it.name
                    tvPrice.text = it.price
                    ivCarImage.setImageResource(it.image)
                    cbFavorite.isChecked = it.isLiked
                    tvCarDescription.text = it.description
                    tvCarCity.text = it.city
                    ivLikesIcon.setImageResource(R.drawable.ic_favorite_thin)
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