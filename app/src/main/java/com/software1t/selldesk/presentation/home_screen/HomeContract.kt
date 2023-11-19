package com.software1t.selldesk.presentation.home_screen

import com.software1t.selldesk.base.UiEffect
import com.software1t.selldesk.base.UiEvent
import com.software1t.selldesk.base.UiState
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel

class HomeContract {

    sealed class Event : UiEvent {
        object OnFetchCars : Event()
        data class OnCarsItemClicked(val car : CarUiModel) : Event()
        object OnGetCategories : Event()
    }

    data class State(
        val categoryState: CategoryState,
        val carsState: CarsState,
        val selectedCar: CarUiModel? = null
    ) : UiState

    sealed class Effect : UiEffect {
        data class ShowError(val message : String?) : Effect()
    }

    sealed class CarsState {
        object Idle : CarsState()
        object Loading : CarsState()
        data class Success(val cars : List<CarUiModel>) : CarsState()
    }

    sealed class CategoryState {
        object Idle : CategoryState()
        object Loading : CategoryState()
        data class Success(val categories : List<CategoryUiModel>) : CategoryState()
    }
}