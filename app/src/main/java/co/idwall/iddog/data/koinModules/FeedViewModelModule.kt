package co.idwall.iddog.data

import co.idwall.iddog.viewModel.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedViewModelModule = module {
    viewModel{ FeedViewModel(get()) }
}