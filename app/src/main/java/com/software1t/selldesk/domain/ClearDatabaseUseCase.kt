package com.software1t.selldesk.domain


interface ClearDatabaseUseCase {
    suspend fun execute()
}

class ClearDatabaseUseCaseImpl(
    private val repository: MyRepository,
) : ClearDatabaseUseCase {

    override suspend fun execute() {

        repository.deleteCarItems()
    }
}