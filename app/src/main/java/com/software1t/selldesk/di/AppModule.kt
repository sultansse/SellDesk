package com.software1t.selldesk.di

import com.software1t.selldesk.presentation.details_screen.DetailsViewModel
import com.software1t.selldesk.presentation.home_screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel()
    }
    viewModel {
        DetailsViewModel()
    }
}