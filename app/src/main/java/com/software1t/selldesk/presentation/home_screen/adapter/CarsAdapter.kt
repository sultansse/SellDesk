package com.software1t.selldesk.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import com.software1t.selldesk.base.BaseRecyclerAdapter
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.databinding.ItemCarBinding
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class CarsAdapter(
    private val clickFunc: ((Int, FragmentNavigator.Extras) -> Unit)? = null,
) : BaseRecyclerAdapter<CarUiModel, ItemCarBinding, CarsAdapter.CarViewHolder>(CarItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CarViewHolder(binding = binding, click = clickFunc)
    }

    class CarViewHolder(
        private val binding: ItemCarBinding,
        private val click: ((Int, FragmentNavigator.Extras) -> Unit)? = null,
    ) : BaseViewHolder<CarUiModel, ItemCarBinding>(binding) {

        init {
            binding.root.setOnClickListener {
                getRowItem()?.let {
                    val extras = FragmentNavigatorExtras(
                        binding.ivCarImage to it.id.toString(),
                    )
                    click?.invoke(it.id, extras)
                }

            }
        }

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    tvCarName.text = it.name
                    tvPrice.text = it.price
                    ivCarImage.setImageResource(it.image)
                    ivCarImage.transitionName = it.id.toString()
                    cbFavorite.isChecked = it.isLiked
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