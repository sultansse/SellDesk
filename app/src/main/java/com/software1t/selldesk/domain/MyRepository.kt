package com.software1t.selldesk.domain

import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.flow.Flow

interface MyRepository {

    suspend fun getAllMyData(): Flow<Resource<List<CarUiModel>>>
}