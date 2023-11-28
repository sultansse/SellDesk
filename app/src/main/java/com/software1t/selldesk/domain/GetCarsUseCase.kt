package com.software1t.selldesk.domain

import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.common.safeApiCall
import com.software1t.selldesk.domain.model.CarDomainModel
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface GetCarsUseCase {
    suspend fun execute(): Flow<Resource<List<CarUiModel>>>
}

class GetCarsUseCaseImpl(
    private val repository: MyRepository,
    private val carMapper: Mapper<CarDomainModel, CarUiModel>,
) : GetCarsUseCase {

    //    better to move logic of flow and safeApiCall to a repository
    override suspend fun execute(): Flow<Resource<List<CarUiModel>>> {

        return flow {
            emit(Resource.Loading)
            delay(4000)
            val response = safeApiCall {
                val carDomainList = repository.getCarItems()
                val carUiList = carMapper.fromList(carDomainList)
                return@safeApiCall carUiList
            }
            emit(response)
        }
    }
}
