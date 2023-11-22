package com.software1t.selldesk.presentation.details_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.base.adapter.DelegateAdapterModel
import com.software1t.selldesk.common.extenshions.tenge
import com.software1t.selldesk.presentation.details_screen.model.DescriptionAdapterModel
import com.software1t.selldesk.presentation.details_screen.model.DividerAdapterModel
import com.software1t.selldesk.presentation.details_screen.model.HeaderAdapterModel

class DetailsViewModel(
    private val itemComposer: DetailsComposer
) : BaseViewModel<DetailsContract.Event, DetailsContract.State, DetailsContract.Effect>() {

    private val _adapterItems = MutableLiveData<List<DelegateAdapterModel>>()
    val adapterItems: LiveData<List<DelegateAdapterModel>> get() = _adapterItems

    private fun updateAdapters(model: DelegateAdapterModel) {
        val items = itemComposer.compose(model)
        _adapterItems.value = items
    }

    override fun createInitialState(): DetailsContract.State {
        return DetailsContract.State(
            carsState = DetailsContract.CarsState.Idle,
        )
    }

    override fun handleEvent(event: DetailsContract.Event) {
        TODO("Not yet implemented")
    }

    init {
        val dividerItem = DividerAdapterModel(true)
        val headerItem = HeaderAdapterModel(
            carName = "Toyota Corolla 2021",
            carPrice = "17 000 000 $tenge",
        )
        val descriptionItem = DescriptionAdapterModel(
            city = "Алматы",
            generation = "2017 - 2021 XV70",
            mileage = "100 000",
            transmission = "Автомат",
            drive = "Передний",
        )

        val myMockCarDetails = listOf<DelegateAdapterModel>(
            dividerItem,
            headerItem,
            dividerItem,
            descriptionItem,
            headerItem,
            dividerItem,
            headerItem,
            descriptionItem,
            dividerItem,
            descriptionItem,
            dividerItem,
        )
        _adapterItems.value = myMockCarDetails
    }
}