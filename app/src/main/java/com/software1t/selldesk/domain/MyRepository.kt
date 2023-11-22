package com.software1t.selldesk.domain

import com.software1t.selldesk.domain.model.CarDomainModel

interface MyRepository {

    suspend fun getAllMyData(): List<CarDomainModel>
}