import kotlinx.serialization.Serializable

@Serializable
data class QrData(
    val id: Long,
    val name: String
)
