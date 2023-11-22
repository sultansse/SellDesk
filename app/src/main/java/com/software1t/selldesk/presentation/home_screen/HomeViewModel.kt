package com.software1t.selldesk.presentation.home_screen

import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.launch

class HomeViewModel(
//    private val itemComposer: HomeComposer,
    private val getMyData: GetMyDataUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            selectedCar = null,
            carsState = HomeContract.CarsState.Idle,
        )
    }

    override fun handleEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.OnFetchCars -> {
                fetchCars()
            }

            is HomeContract.Event.OnCarsItemClicked -> {
                val item = event.car
                setSelectedCar(car = item)
            }
        }
    }

    private fun fetchCars() {
        viewModelScope.launch {
            getMyData.execute().collect() {
                when (it) {
                    is Resource.Loading -> {
                        setState { copy(carsState = HomeContract.CarsState.Loading) }
                    }

                    is Resource.Success -> {
                        setState { copy(carsState = HomeContract.CarsState.Success(it.data)) }
                    }

                    is Resource.Error -> {
                        setEffect { HomeContract.Effect.ShowError(message = it.errorBody) }
                    }
                }

            }
        }
    }

    private fun setSelectedCar(car: CarUiModel?) {
        setState { copy(selectedCar = car) }
    }
}