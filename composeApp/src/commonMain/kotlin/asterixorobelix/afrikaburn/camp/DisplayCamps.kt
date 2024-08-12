package asterixorobelix.afrikaburn.camp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.resources.Dimens
import asterixorobelix.afrikaburn.resources.Strings
import asterixorobelix.afrikaburn.ui.boldPrefixText

@Composable
fun campsList(camps: List<ThemeCamp>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background)
    ) {
        items(camps.count()) {
            Card(
                modifier = Modifier.padding(Dimens.SMALL_SPACING),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = Dimens.SMALL_SPACING,
                        vertical = Dimens.SMALL_SPACING
                    )
                ) {
                    boldPrefixText(prefix = Strings.NAME, camps[it].name)
                    boldPrefixText(prefix = Strings.COLLECTIVE, camps[it].collective)
                    boldPrefixText(prefix = Strings.DESCRIPTION, camps[it].description)
                    boldPrefixText(prefix = Strings.SCHEDULE_DESCRIPTION, camps[it].scheduleDetail)
                }
            }

        }
    }
}