package asterixorobelix.afrikaburn.models

import kotlinx.serialization.Serializable

@Serializable
data class Artwork(
    val label: String,
    val name: String,
    val location: Location,
    val description: String,
    val collective: String,
    val burning: Boolean,
    val burningDay: Long?,
    val sound: Boolean,
    val artworkHeight: Double,
    val artworkWidth: Double,
    val artworkDepth: Double,
)
