package co.idwall.iddog.data

import org.koin.dsl.module

val feedRepository = module {
 factory { FeedRepository() }
}