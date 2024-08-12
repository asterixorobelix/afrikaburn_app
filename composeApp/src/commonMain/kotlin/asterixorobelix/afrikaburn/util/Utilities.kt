package asterixorobelix.afrikaburn.util

inline fun String.isDefinitelyNotNullOrEmpty(): Boolean = this.isNotEmpty() && this != "null"