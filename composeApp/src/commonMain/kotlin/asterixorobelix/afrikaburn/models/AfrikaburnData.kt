package asterixorobelix.afrikaburn.models

import kotlinx.serialization.Serializable

@Serializable
data class AfrikaburnData(
    val themeCamps: List<ThemeCamp>,
    val supportCamps: List<String>? = null,
    val artwork: List<Artwork>,
)
