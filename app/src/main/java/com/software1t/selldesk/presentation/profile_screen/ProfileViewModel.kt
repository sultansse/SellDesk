package com.software1t.selldesk.presentation.profile_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.software1t.selldesk.base.BaseViewModel
import com.software1t.selldesk.base.adapter.DelegateAdapterModel
import com.software1t.selldesk.common.model.ButtonAdapterModel
import com.software1t.selldesk.common.model.DividerAdapterModel
import com.software1t.selldesk.domain.ClearDatabaseUseCase
import com.software1t.selldesk.domain.PopulateDbUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val populateDatabase: PopulateDbUseCase,
    private val clearDatabase: ClearDatabaseUseCase,
) : BaseViewModel<ProfileContract.Event, ProfileContract.State, ProfileContract.Effect>() {

    private val _adapterItems = MutableLiveData<List<DelegateAdapterModel>>()
    val adapterItems: LiveData<List<DelegateAdapterModel>> get() = _adapterItems

    override fun createInitialState(): ProfileContract.State {
        return ProfileContract.State(
            carsState = ProfileContract.CarsState.Idle,
        )
    }

    override fun handleEvent(event: ProfileContract.Event) {
        TODO("Not yet implemented")
    }

    private fun populateDatabase() {
        viewModelScope.launch {
            populateDatabase.execute()
        }
    }

    private fun clearDatabase() {
        viewModelScope.launch {
            clearDatabase.execute()
        }
    }

    init {
        val dividerItem = DividerAdapterModel(true)
        val populateButtonItem = ButtonAdapterModel(
            text = "mock database",
            btnClick = ::populateDatabase,
        )
        val clearButtonItem = ButtonAdapterModel(
            text = "clear database",
            btnClick = ::clearDatabase,
        )


        val myMockCarDetails = listOf<DelegateAdapterModel>(
            dividerItem,
            populateButtonItem,
            clearButtonItem,
            dividerItem,
        )
        _adapterItems.value = myMockCarDetails
    }
}