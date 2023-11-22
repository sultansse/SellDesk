package com.software1t.selldesk.presentation.details_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.databinding.DelegateDetailsDescriptionBinding
import com.software1t.selldesk.presentation.details_screen.model.DescriptionAdapterModel

class DetailsDescriptionAdapter :
    DelegateAdapter<DescriptionAdapterModel, DelegateDetailsDescriptionBinding, DetailsDescriptionAdapter.DescriptionViewHolder>(
        DescriptionAdapterModel::class.java
    ) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<DescriptionAdapterModel, DelegateDetailsDescriptionBinding> {
        val binding = DelegateDetailsDescriptionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DescriptionViewHolder(binding = binding)
    }

    class DescriptionViewHolder(
        private val binding: DelegateDetailsDescriptionBinding,
    ) : BaseViewHolder<DescriptionAdapterModel, DelegateDetailsDescriptionBinding>(binding) {

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    tvCityValue.text = it.city
                    tvGenerationValue.text = it.generation
                    tvMileageValue.text = it.mileage
                    tvTransmissionValue.text = it.transmission
                    tvDriveValue.text = it.drive
                }
            }
        }
    }
}