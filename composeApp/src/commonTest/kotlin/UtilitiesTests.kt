import asterixorobelix.afrikaburn.util.isDefinitelyNotNullOrEmpty
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UtilitiesTests {

    @Test
    fun populatedStringShouldReturnTrue() {
        assertTrue("Hello".isDefinitelyNotNullOrEmpty())
    }

    @Test
    fun nullStringShouldReturnFalse() {
        assertFalse("null".isDefinitelyNotNullOrEmpty())
    }

    @Test
    fun emptyShouldReturnFalse() {
        assertFalse("".isDefinitelyNotNullOrEmpty())
    }
}