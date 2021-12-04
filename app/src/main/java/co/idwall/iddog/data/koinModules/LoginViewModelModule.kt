package co.idwall.iddog.data

import co.idwall.iddog.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginViewModelModule = module {
    viewModel{ LoginViewModel(get()) }
}