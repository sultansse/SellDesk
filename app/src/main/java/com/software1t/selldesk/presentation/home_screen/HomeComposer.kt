package com.software1t.selldesk.presentation.home_screen

import com.software1t.selldesk.base.adapter.DelegateAdapterModel

class HomeComposer {
    fun compose(model: DelegateAdapterModel): List<DelegateAdapterModel> {
        val items = mutableListOf<DelegateAdapterModel>()

//        categories
        items.add(model)

        return items
    }
}