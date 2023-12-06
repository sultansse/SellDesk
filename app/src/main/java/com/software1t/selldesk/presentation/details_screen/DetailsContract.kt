package com.software1t.selldesk.presentation.details_screen

import com.software1t.selldesk.base.UiEffect
import com.software1t.selldesk.base.UiEvent
import com.software1t.selldesk.base.UiState
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class DetailsContract {

    sealed class Event : UiEvent {
        data class OnFetchCar(val carId: Int) : Event()
    }

    data class State(
        val carsState: CarsState,
    ) : UiState

    sealed class Effect : UiEffect {
        data class ShowError(val message: String?) : Effect()
    }

    sealed class CarsState {
        object Idle : CarsState()
        object Loading : CarsState()
        data class Success(val cars: List<CarUiModel>) : CarsState()
    }
}