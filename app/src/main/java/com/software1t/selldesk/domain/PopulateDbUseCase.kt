package com.software1t.selldesk.domain


interface PopulateDbUseCase {
    suspend fun execute()
}

class PopulateDbUseCaseImpl(
    private val repository: MyRepository,
) : PopulateDbUseCase {

    override suspend fun execute() {
        repository.populateWithMockData()
    }
}