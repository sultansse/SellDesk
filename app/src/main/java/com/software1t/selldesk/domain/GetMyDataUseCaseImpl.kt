package com.software1t.selldesk.domain

import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.common.safeApiCall
import com.software1t.selldesk.domain.model.CarDomainModel
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface GetMyDataUseCase {
    suspend fun execute(): Flow<Resource<List<CarUiModel>>>
}

class GetMyDataUseCaseImpl(
    private val repository: MyRepository,
    private val carMapper: Mapper<CarDomainModel, CarUiModel>,
) : GetMyDataUseCase {

//    better to move logic of flow and safeApiCall to a repository
    override suspend fun execute(): Flow<Resource<List<CarUiModel>>> {

        return flow {
            emit(Resource.Loading)
//            delay(3000)
            val response = safeApiCall {
                val carDomainList = repository.getAllMyData()
                val carUiList = carMapper.fromList(carDomainList)
                return@safeApiCall carUiList
            }
            emit(response)
        }
    }
}