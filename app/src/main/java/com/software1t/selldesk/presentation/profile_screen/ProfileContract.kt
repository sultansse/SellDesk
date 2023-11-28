package com.software1t.selldesk.presentation.profile_screen

import com.software1t.selldesk.base.UiEffect
import com.software1t.selldesk.base.UiEvent
import com.software1t.selldesk.base.UiState
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class ProfileContract {

    sealed class Event : UiEvent {
        object OnFetchCars : Event()
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