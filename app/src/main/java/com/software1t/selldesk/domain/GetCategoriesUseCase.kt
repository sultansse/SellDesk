package com.software1t.selldesk.domain

import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel
import kotlinx.coroutines.flow.Flow

class GetCategoriesUseCase (
    private val repository: MyRepository
) {

    suspend operator fun invoke() : Flow<Resource<List<CategoryUiModel>>> {
        return repository.getCategories()
    }
}
