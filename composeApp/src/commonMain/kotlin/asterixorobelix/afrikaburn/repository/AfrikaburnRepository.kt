package asterixorobelix.afrikaburn.repository

import asterixorobelix.afrikaburn.models.AfrikaburnData
import asterixorobelix.afrikaburn.models.CIDisplayElement
import asterixorobelix.afrikaburn.models.CreativeInitiativeDisplayElement
import asterixorobelix.afrikaburn.monday.CreativeInitiativesQuery
import asterixorobelix.afrikaburn.network.NetworkClient
import com.apollographql.apollo.ApolloClient
import io.ktor.client.plugins.logging.Logging

class AfrikaburnRepository(private val networkClient: NetworkClient, private val apolloClient: ApolloClient) {

    suspend fun retrieveAfrikaburnInfo(): List<CreativeInitiativeDisplayElement>? {
        val data = retrieveViaApollo()
        return data.data?.boards?.first()?.items_page?.items?.mapIndexed { _, item ->
            CreativeInitiativeDisplayElement(item.name, item.column_values.mapIndexed { _, columnValue ->
                CIDisplayElement(title =columnValue.column.title , textContent = columnValue.text)
            })
        }?.toList()
    }

    private suspend fun retrieveViaApollo()= apolloClient.query(CreativeInitiativesQuery()).execute()
}