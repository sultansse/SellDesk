package com.software1t.selldesk.presentation.details_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.databinding.DelegateDetailsImageBinding
import com.software1t.selldesk.presentation.details_screen.model.ImageAdapterModel

class DetailsImageAdapter :
    DelegateAdapter<ImageAdapterModel, DelegateDetailsImageBinding, DetailsImageAdapter.ImageViewHolder>(
        ImageAdapterModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<ImageAdapterModel, DelegateDetailsImageBinding> {
        val binding = DelegateDetailsImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageViewHolder(binding = binding)
    }

    class ImageViewHolder(
        private val binding: DelegateDetailsImageBinding,
    ) : BaseViewHolder<ImageAdapterModel, DelegateDetailsImageBinding>(binding) {

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    ivCarImage.setImageResource(it.carImage)
                }
            }
        }
    }
}