package com.software1t.selldesk.data.repository

import com.software1t.selldesk.data.model.CategoryDataModel
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

interface LocalDataSource {

    suspend fun getAllMyData(): List<CarUiModel>
}