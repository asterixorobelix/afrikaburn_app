package asterixorobelix.afrikaburn.models

import kotlinx.serialization.Serializable

@Serializable
data class ThemeCamp(
    val label: String,
    val location: Location,
    val name: String,
    val description: String,
    val collective: String,
    val openDays: List<Long>?,
    val openTimes: List<Long>?,
    val scheduleDetail: String,
    val children: Long?,
)
