package com.software1t.selldesk.local.source

import com.software1t.selldesk.data.MyData
import com.software1t.selldesk.data.model.CategoryDataModel
import com.software1t.selldesk.data.repository.LocalDataSource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel

class LocalDataSourceImpl : LocalDataSource {

    override suspend fun getAllMyData(): List<CarUiModel> {
        return MyData.myData
    }
}
