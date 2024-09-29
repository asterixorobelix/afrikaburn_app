package asterixorobelix.afrikaburn.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun map(
    modifier: Modifier,
    contentPadding: PaddingValues
) {
//    val polygonsState = remember { MutableStateFlow(polygons) }
//    val contentPaddingState = remember { MutableStateFlow(contentPadding) }
    val mapWithSwiftUIViewFactory = remember {
        mapWithSwiftUIViewFactory(
//            polygonsState.asStateFlow(),
//            contentPaddingState.asStateFlow()
        )
    }
    UIKitViewController(
        factory = { mapWithSwiftUIViewFactory.viewController },
        update = {
//            polygonsState.update { polygons }
//            contentPaddingState.update { contentPadding }
        },
        modifier = modifier,
    )
}

internal lateinit var mapWithSwiftUIViewFactory: (
//    polygonsState: StateFlow<ImmutableList<Polygon>>,
//    contentPaddingState: StateFlow<PaddingValues>,
) -> MapWithSwiftUIViewFactory

interface MapWithSwiftUIViewFactory {
    val viewController: UIViewController

}