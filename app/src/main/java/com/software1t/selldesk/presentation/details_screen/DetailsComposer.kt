package com.software1t.selldesk.presentation.details_screen

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class DetailsComposer {

    fun compose(model: DelegateAdapterModel): List<DelegateAdapterModel> {
        val items = mutableListOf<DelegateAdapterModel>()

//        header
        items.add(model)

//        divider
        items.add(model)

        return items
    }
}