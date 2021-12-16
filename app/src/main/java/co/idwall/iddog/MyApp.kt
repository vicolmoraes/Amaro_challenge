package co.idwall.iddog

import android.app.Application
import co.idwall.iddog.data.feedRepository
import co.idwall.iddog.data.feedViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(listOf(feedRepository, feedViewModelModule))
        }
    }
}