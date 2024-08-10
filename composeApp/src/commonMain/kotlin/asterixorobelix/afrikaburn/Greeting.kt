package asterixorobelix.afrikaburn

import asterixorobelix.afrikaburn.repository.AfrikaburnRepository

class Greeting() {
    private val platform = getPlatform()
    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}