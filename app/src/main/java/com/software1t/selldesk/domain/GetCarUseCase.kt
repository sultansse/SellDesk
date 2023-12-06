package com.software1t.selldesk.domain

import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.common.safeApiCall
import com.software1t.selldesk.domain.model.CarDomainModel
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface GetCarUseCase {
    suspend fun execute(carId: Int): Flow<Resource<CarUiModel>>
}

class GetCarUseCaseImpl(
    private val repository: MyRepository,
    private val carMapper: Mapper<CarDomainModel, CarUiModel>,
) : GetCarUseCase {

    //    better to move logic of flow and safeApiCall to a repository
    override suspend fun execute(carId: Int): Flow<Resource<CarUiModel>> {

        return flow {
            emit(Resource.Loading)
            val response = safeApiCall {
                val carDomain = repository.getCarItem(carId)
                val carUiModel = carMapper.from(carDomain)
                return@safeApiCall carUiModel
            }
            emit(response)
        }
    }
}
