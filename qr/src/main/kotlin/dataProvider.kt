import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object DataProvider {

    private val data = QrData(
    id = 7348325904,
    name = "Chillaz"
    )
    fun retrieveData() = data
}