package com.software1t.selldesk.data

import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.data.model.LocalDataSource
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class MyRepositoryImpl(
    private val localDataSource: LocalDataSource,
//    private val remoteDataSource: RemoteDataSource,
) : MyRepository {

    override suspend fun getAllMyData(): Flow<Resource<List<CarUiModel>>> {
        return flow {
            try {
                val local = localDataSource.getAllMyData()
                emit(Resource.Success(local))
            } catch (ex1: Exception) {
                emit(Resource.Error(ex1))
            }

        }
    }
}