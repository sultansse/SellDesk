package com.software1t.selldesk.presentation.home_screen

import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.domain.GetCategoriesUseCase
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMyData: GetMyDataUseCase,
    private val getCategories: GetCategoriesUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            selectedCar = null,
            carsState = HomeContract.CarsState.Idle,
            categoryState = HomeContract.CategoryState.Idle,
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

            is HomeContract.Event.OnGetCategories -> {
                getCategories()
            }
        }
    }

    private fun setSelectedCar(car: CarUiModel?) {
        setState { copy(selectedCar = car) }
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

    private fun getCategories() {
//        its local buttons i just do it as recyclerview instead of gridlayout.
//        why its local? i just wanted to demonstrate delegateAdapter (multiAdapter)
        viewModelScope.launch {
            getCategories.invoke().collect() {
                when (it) {
                    is Resource.Loading -> {
                        setState { copy(categoryState = HomeContract.CategoryState.Loading) }
                    }

                    is Resource.Empty -> {
                        setState { copy(categoryState = HomeContract.CategoryState.Idle) }
                    }

                    is Resource.Success -> {
                        setState { copy(categoryState = HomeContract.CategoryState.Success(it.data)) }
                    }

                    is Resource.Error -> {
                        setEffect { HomeContract.Effect.ShowError(message = it.exception.message) }
                    }
                }
            }
        }
    }

}