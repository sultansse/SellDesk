package com.software1t.selldesk.presentation.details_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class DetailsViewModel(
    private val itemComposer: DetailsComposer
) : BaseViewModel<DetailsContract.Event, DetailsContract.State, DetailsContract.Effect>() {

    private val _adapterItems = MutableLiveData<List<DelegateAdapterModel>>()
    val adapterItems: LiveData<List<DelegateAdapterModel>> get() = _adapterItems

    private fun updateAdapters(model: DelegateAdapterModel) {
//        val items = itemComposer.compose(model)
//        _adapterItems.value = items
    }

    override fun createInitialState(): DetailsContract.State {
        return DetailsContract.State(
            carsState = DetailsContract.CarsState.Idle,
        )
    }

    override fun handleEvent(event: DetailsContract.Event) {
        TODO("Not yet implemented")
    }
}