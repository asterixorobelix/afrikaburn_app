package asterixorobelix.afrikaburn

import android.app.Application
import asterixorobelix.afrikaburn.di.commonModule
import asterixorobelix.afrikaburn.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
        }
    }
}