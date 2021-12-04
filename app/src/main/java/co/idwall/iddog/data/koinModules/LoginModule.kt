package co.idwall.iddog.data

import org.koin.dsl.module

val loginRepository = module {
 factory { LoginRepository() }
}