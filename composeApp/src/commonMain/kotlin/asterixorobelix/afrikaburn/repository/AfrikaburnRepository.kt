package asterixorobelix.afrikaburn.repository

import asterixorobelix.afrikaburn.monday.CreativeInitiativesQuery
import asterixorobelix.afrikaburn.network.NetworkClient
import com.apollographql.apollo.ApolloClient

class AfrikaburnRepository(private val networkClient: NetworkClient, private val apolloClient: ApolloClient) {

    suspend fun retrieveAfrikaburnInfo() = networkClient.getAfrikaburnInfo()

    suspend fun retrieveViaApollo()= apolloClient.query(CreativeInitiativesQuery()).execute()
}