package com.software1t.selldesk.domain

import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel

class GetCategoriesUseCase (
    private val repository: MyRepository
) {

    suspend operator fun invoke() : CategoryUiModel {
        val categoryDataList = repository.getCategories()
        return CategoryUiModel(
            title1 = categoryDataList[0].title,
            icon1 = categoryDataList[0].icon,
            title2 = categoryDataList[1].title,
            icon2 = categoryDataList[1].icon,
            title3 = categoryDataList[2].title,
            icon3 = categoryDataList[2].icon,
            title4 = categoryDataList[3].title,
            icon4 = categoryDataList[3].icon,
            title5 = categoryDataList[4].title,
            icon5 = categoryDataList[4].icon,
            title6 = categoryDataList[5].title,
            icon6 = categoryDataList[5].icon
        )
    }
}
