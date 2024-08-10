package asterixorobelix.afrikaburn

import androidx.compose.ui.window.ComposeUIViewController
import asterixorobelix.afrikaburn.di.commonModule
import asterixorobelix.afrikaburn.di.initKoin
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) {
    App()
}