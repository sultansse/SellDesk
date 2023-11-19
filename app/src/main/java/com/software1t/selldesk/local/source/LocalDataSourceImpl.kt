package com.software1t.selldesk.local.source

import com.software1t.selldesk.data.MyData
import com.software1t.selldesk.data.model.LocalDataSource
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.delay

class LocalDataSourceImpl : LocalDataSource {

    override suspend fun getAllMyData(): List<CarUiModel> {
        delay(4000)
        return MyData.myData
    }
}
