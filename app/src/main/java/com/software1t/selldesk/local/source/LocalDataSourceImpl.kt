package com.software1t.selldesk.local.source

import com.software1t.selldesk.data.MyData
import com.software1t.selldesk.data.model.LocalDataSource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel

class LocalDataSourceImpl : LocalDataSource {

    override suspend fun getAllMyData(): List<CarUiModel> {
        return MyData.myData
    }

    override suspend fun getCategories(): List<CategoryUiModel> {
        return MyData.categories
    }
}
