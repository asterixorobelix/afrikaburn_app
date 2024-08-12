package asterixorobelix.afrikaburn.camp

import afrikaburn.composeapp.generated.resources.Res
import afrikaburn.composeapp.generated.resources.collective
import afrikaburn.composeapp.generated.resources.description
import afrikaburn.composeapp.generated.resources.name
import afrikaburn.composeapp.generated.resources.schedule_description
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.resources.Dimens
import asterixorobelix.afrikaburn.ui.boldPrefixText
import org.jetbrains.compose.resources.stringResource

@Composable
fun campsList(camps: List<ThemeCamp>, isLoading: State<Boolean>) {
    if (isLoading.value) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(MaterialTheme.colorScheme.background)
        )
    } else {
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
                        boldPrefixText(prefix = stringResource(Res.string.name), camps[it].name)
                        boldPrefixText(
                            prefix = stringResource(Res.string.collective),
                            camps[it].collective
                        )
                        boldPrefixText(
                            prefix = stringResource(Res.string.description),
                            camps[it].description
                        )
                        boldPrefixText(
                            prefix = stringResource(Res.string.schedule_description),
                            camps[it].scheduleDetail
                        )
                    }
                }

            }
        }

    }
}