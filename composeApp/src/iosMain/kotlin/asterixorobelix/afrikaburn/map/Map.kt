package asterixorobelix.afrikaburn.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.interop.UIKitViewController
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.MapKit.MKMapView
import platform.UIKit.UITextView
import platform.UIKit.UIViewController
import cocoapods.MapLibre.MLNMapView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun map(
    modifier: Modifier,
    contentPadding: PaddingValues
) {
    UIKitView(
        factory = { MLNMapView() },
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
    )
}