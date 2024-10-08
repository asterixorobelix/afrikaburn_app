package asterixorobelix.afrikaburn.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import asterixorobelix.afrikaburn.resources.Dimens
import asterixorobelix.afrikaburn.util.isDefinitelyNotNullOrEmpty

/**
 * Does not display if the [text] is empty
 */
@Composable
fun boldPrefixText(prefix: String, text: String?) {
    if (text?.isDefinitelyNotNullOrEmpty() == true) {
        Column {
            Text(
                fontWeight = FontWeight.ExtraBold,
                text = prefix,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text,
                modifier = Modifier.padding(start = Dimens.SMALL_SPACING),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}