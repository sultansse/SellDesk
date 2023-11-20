package com.software1t.selldesk.presentation.home_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.base.adapter.DelegateAdapterModel
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.domain.GetCategoriesUseCase
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val itemComposer: HomeComposer,
    private val getMyData: GetMyDataUseCase,
    private val getCategories: GetCategoriesUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    private val _listItems = MutableLiveData<List<DelegateAdapterModel>>()
    val listItems : LiveData<List<DelegateAdapterModel>>
        get() = _listItems

//    private val _compositeItems : MutableStateFlow<State> = MutableStateFlow(initialState)
//    val compositeItems = _compositeItems.asStateFlow()

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
                fetchCategories()
            }
        }
    }

    private fun updateAdapters(model: DelegateAdapterModel) {
        val items = itemComposer.compose(model)
        _listItems.value = items
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

    private fun setSelectedCar(car: CarUiModel?) {
        setState { copy(selectedCar = car) }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            updateAdapters(getCategories.invoke())
        }
    }
}