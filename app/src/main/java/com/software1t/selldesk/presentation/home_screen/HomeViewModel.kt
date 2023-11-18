package com.software1t.selldesk.presentation.home_screen

import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.base.UiEffect
import com.software1t.selldesk.base.UiEvent
import com.software1t.selldesk.base.UiState
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMyData: GetMyDataUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            carsState = HomeContract.CarsState.Idle,
            selectedCar = null
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
            getMyData.invoke().collect() {
                when (it) {
                    is Resource.Loading -> {
                        setState { copy(carsState = HomeContract.CarsState.Loading) }
                    }

                    is Resource.Empty -> {
                        setState { copy(carsState = HomeContract.CarsState.Idle) }
                    }

                    is Resource.Success -> {
                        setState { copy(carsState = HomeContract.CarsState.Success(it.data)) }
                    }

                    is Resource.Error -> {
                        setEffect { HomeContract.Effect.ShowError(message = it.exception.message) }
                    }
                }

            }
        }
    }

    private fun setSelectedCar(car : CarUiModel?) {
        setState { copy(selectedCar = car) }
    }
}