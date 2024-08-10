package asterixorobelix.afrikaburn.models

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
