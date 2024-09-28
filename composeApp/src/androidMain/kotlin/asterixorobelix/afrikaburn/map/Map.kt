package asterixorobelix.afrikaburn.map

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import asterixorobelix.afrikaburn.R
import kotlinx.coroutines.CoroutineScope
import org.maplibre.android.MapLibre
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapView
import org.maplibre.android.maps.Style

@Composable
actual fun map(
    modifier: Modifier,
    contentPadding: PaddingValues,
) {
    Box {
        org.ramani.compose.MapLibre(modifier = Modifier.fillMaxSize())
    }
//    val map = rememberMapViewWithLifecycle()
//    AndroidView(
//        modifier = Modifier.fillMaxSize(),
//        factory = { map },
//        update = { mapView ->
//            val onMapReady = object : OnMapReady {
//                override fun whenReady() {
//
//                }
//
//            }
//            mapView.awaitMap(onMapReady)
//        }
//
//    )
}

/**
 * Remembers a MapView and gives it the lifecycle of the current LifecycleOwner
 */
@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    // Makes MapView follow the lifecycle of this composable
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle, mapView) {
        val lifecycleObserver = getMapLifecycleObserver(mapView)
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }

    return mapView
}

private fun getMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
            Lifecycle.Event.ON_START -> mapView.onStart()
            Lifecycle.Event.ON_RESUME -> mapView.onResume()
            Lifecycle.Event.ON_PAUSE -> mapView.onPause()
            Lifecycle.Event.ON_STOP -> mapView.onStop()
            Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
            else -> throw IllegalStateException()
        }
    }

fun MapView.awaitMap(onMapReady: OnMapReady) =
    getMapAsync { map ->
        map.setStyle("https://demotiles.maplibre.org/style.json")
        map.cameraPosition = CameraPosition.Builder().target(LatLng(0.0,0.0)).zoom(1.0).build()
        onMapReady.whenReady()

//        libreMap.setStyle(
//            Style.Builder().fromJson(
////                        ResourceReader.readRawResource(
////                            context,
////                            R.raw.mapbox_style
////                        ) ?: ""
//                ""
//            )
//        )
    }

interface OnMapReady {
    fun whenReady()
}

