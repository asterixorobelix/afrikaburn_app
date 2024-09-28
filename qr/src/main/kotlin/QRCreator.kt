import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import qrcode.QRCode
import qrcode.color.Colors
import java.io.FileOutputStream

object QRCreator {
    //https://github.com/g0dkar/qrcode-kotlin
    fun createQR(data:QrData){

        // JVM-only code: For our platform-independent code we just need a ByteArray of the PNG logo :)
        val logoBytes = ClassLoader.getSystemResourceAsStream("afrikaburnLogo.png")?.readBytes()
        val jsonData = Json.encodeToString(data)
        val qrCode = QRCode.ofCircles()
            .withColor(Colors.DEEP_SKY_BLUE) // Default is Colors.BLACK
            .withLogo(logoBytes, QR_SIZE*10, QR_SIZE*10, clearLogoArea = false)
            .withSize(QR_SIZE) // Default is 25
            .build(jsonData)

        // By default, QRCodes are rendered as PNGs.
        val pngBytes = qrCode.render().getBytes()

        FileOutputStream("${data.id}.png").use { it.write(pngBytes) }
    }

    const val QR_SIZE = 20
}