package asterixorobelix.afrikaburn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import afrikaburn.composeapp.generated.resources.Res
import afrikaburn.composeapp.generated.resources.compose_multiplatform
import androidx.lifecycle.viewModelScope
import asterixorobelix.afrikaburn.viewmodel.CampViewModel
import io.ktor.client.call.body
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            var showContent by remember { mutableStateOf(false) }
            val viewModel = koinViewModel<CampViewModel>()
            val coroutineScope = rememberCoroutineScope()
            val data = remember { mutableStateOf("") }
            coroutineScope.launch {
                data.value = viewModel.getCamps()?.toString() ?: ""
            }

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                            Image(painterResource(Res.drawable.compose_multiplatform), null)
                            Text("Compose: ${data.value}")
                    }
                }
            }

        }
    }

}