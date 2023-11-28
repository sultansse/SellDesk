package com.software1t.selldesk.presentation.favorites_screen

import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.domain.GetFavoriteCarsUseCase
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoriteCars: GetFavoriteCarsUseCase,
) : BaseViewModel<FavoritesContract.Event, FavoritesContract.State, FavoritesContract.Effect>() {

    override fun createInitialState(): FavoritesContract.State {
        return FavoritesContract.State(
            carsState = FavoritesContract.CarsState.Idle,
        )
    }

    override fun handleEvent(event: FavoritesContract.Event) {
        when (event) {
            is FavoritesContract.Event.OnFetchCars -> {
                fetchCars()
            }

        }
    }

    private fun fetchCars() {
        viewModelScope.launch {
            getFavoriteCars.execute().collect() {
                when (it) {
                    is Resource.Loading -> {
                        setState { copy(carsState = FavoritesContract.CarsState.Loading) }
                    }

                    is Resource.Success -> {
                        setState { copy(carsState = FavoritesContract.CarsState.Success(it.data)) }
                    }

                    is Resource.Error -> {
                        setEffect { FavoritesContract.Effect.ShowError(message = it.errorBody) }
                    }
                }

            }
        }
    }
}