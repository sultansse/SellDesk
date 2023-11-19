package com.software1t.selldesk.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.software1t.selldesk.R
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.databinding.CarItemBinding
import com.software1t.selldesk.databinding.GridTableItemBinding
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel

class CarsAdapter (
    private val clickFunc : (() -> Unit)? = null
) : DelegateAdapter<CarUiModel, CarItemBinding, CarsAdapter.CarViewHolder>(CarUiModel::class.java) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<CarUiModel, CarItemBinding> {
        val binding = CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding = binding, click = clickFunc)
    }

    class CarViewHolder (
        private val binding : CarItemBinding,
        private val click : (() -> Unit)? = null
    ) : BaseViewHolder<CarUiModel, CarItemBinding>(binding) {

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