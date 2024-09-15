package asterixorobelix.afrikaburn.models

import asterixorobelix.afrikaburn.monday.CreativeInitiativesQuery
import kotlinx.serialization.Serializable

data class AfrikaburnData(
    val creativeInitiatives: List<CreativeInitiativesQuery.Item>?
)
