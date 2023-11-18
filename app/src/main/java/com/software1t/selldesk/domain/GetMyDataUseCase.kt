package com.software1t.selldesk.domain

import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.flow.Flow

class GetMyDataUseCase (
    private val repository: MyRepository
) {

    suspend operator fun invoke() : Flow<Resource<List<CarUiModel>>> {
        return repository.getAllMyData()
    }
}
