package com.software1t.selldesk.presentation.favorites_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.software1t.selldesk.base.BaseRecyclerAdapter
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.databinding.ItemCarFavoritesBinding
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class FavoriteCarsAdapter(
    private val clickFunc: ((Int) -> Unit)? = null
) : BaseRecyclerAdapter<CarUiModel, ItemCarFavoritesBinding, FavoriteCarsAdapter.CarViewHolder>(
    FavoriteCarItemDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarFavoritesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CarViewHolder(binding = binding, click = clickFunc)
    }

    class CarViewHolder(
        private val binding: ItemCarFavoritesBinding,
        private val click: ((Int) -> Unit)? = null
    ) : BaseViewHolder<CarUiModel, ItemCarFavoritesBinding>(binding) {

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
                }
            }
        }
    }
}

class FavoriteCarItemDiffUtil : DiffUtil.ItemCallback<CarUiModel>() {
    override fun areItemsTheSame(oldItem: CarUiModel, newItem: CarUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarUiModel, newItem: CarUiModel): Boolean {
        return oldItem == newItem
    }
}