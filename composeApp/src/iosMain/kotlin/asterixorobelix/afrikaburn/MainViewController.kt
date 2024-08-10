package asterixorobelix.afrikaburn

import androidx.compose.ui.window.ComposeUIViewController
import asterixorobelix.afrikaburn.di.commonModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    startKoin {
        modules(commonModule)
    }
    App()
}