package com.software1t.selldesk.presentation.details_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.base.adapter.DelegateAdapterModel
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.common.extenshions.tenge
import com.software1t.selldesk.common.model.DividerAdapterModel
import com.software1t.selldesk.domain.GetCarUseCase
import com.software1t.selldesk.presentation.details_screen.model.DescriptionAdapterModel
import com.software1t.selldesk.presentation.details_screen.model.HeaderAdapterModel
import com.software1t.selldesk.presentation.details_screen.model.ImageAdapterModel
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val itemComposer: DetailsComposer,
    private val getCar: GetCarUseCase,
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
        when (event) {
            is DetailsContract.Event.OnFetchCar -> {
                fetchCar(event.carId)
            }
        }
    }

    private fun fetchCar(carId: Int) {
        viewModelScope.launch {
            getCar.execute(carId).collect() {
                when (it) {
                    is Resource.Loading -> {
                        setState { copy(carsState = DetailsContract.CarsState.Loading) }
                    }

                    is Resource.Success -> {
                        val image = ImageAdapterModel(
                            carImage = it.data.image,
                        )
                        val header = HeaderAdapterModel(
                            carName = it.data.name,
                            carPrice = it.data.price,
                        )
                        val description = DescriptionAdapterModel(
                            city = it.data.city,
                            generation = "2017 - 2021 XV70",
                            mileage = "100 000",
                            transmission = it.data.description,
                            drive = "4wd",
                        )
                        val divider = DividerAdapterModel(true)
                        _adapterItems.value = listOf(image, header, description, divider)
                    }

                    is Resource.Error -> {
                        setEffect { DetailsContract.Effect.ShowError(message = it.errorBody) }
                    }
                }

            }
        }
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