package com.software1t.selldesk.data.model

import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

   suspend fun getAllMyData(): List<CarUiModel>
}