package asterixorobelix.afrikaburn.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import asterixorobelix.afrikaburn.resources.Dimens

@Composable
fun boldPrefixText(prefix: String, text: String?) {
    if (text?.isNotEmpty() == true) {
        Row {
            Text(fontWeight = FontWeight.ExtraBold, text = prefix)
            Text(text, modifier = Modifier.padding(start = Dimens.SMALL_SPACING))
        }
    }
}