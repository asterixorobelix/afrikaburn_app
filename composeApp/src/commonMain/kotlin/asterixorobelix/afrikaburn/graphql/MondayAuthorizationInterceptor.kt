package asterixorobelix.afrikaburn.graphql

import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.apollographql.apollo.network.http.HttpInterceptor
import com.apollographql.apollo.network.http.HttpInterceptorChain

/**
 * @param token api token
 * @param apiVersion eg: 2024-07 see monday.com documentation
 */
class MondayAuthorizationInterceptor(private val token: String, private val apiVersion:String) : HttpInterceptor {
    override suspend fun intercept(
        request: HttpRequest,
        chain: HttpInterceptorChain
    ): HttpResponse {
        return chain.proceed(
            request.newBuilder()
                .addHeader("Authorization", token)
                .addHeader("API-Version", apiVersion)
                .build()
        )
    }
}