package asterixorobelix.afrikaburn.camp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.resources.Dimens
import asterixorobelix.afrikaburn.resources.Strings
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun campsList(camps: List<ThemeCamp>) {
    LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = Modifier.fillMaxWidth()) {
        items(camps.count()) {
            Column(modifier = Modifier.padding(horizontal = Dimens.SMALL_SPACING)) {
                Text("${Strings.NAME} ${camps[it].name}")
                Text("${Strings.COLLECTIVE} ${camps[it].collective}")
                Text("${Strings.DESCRIPTION} ${camps[it].description}")
                Text("${Strings.SCHEDULE_DESCRIPTION} ${camps[it].scheduleDetail}")
            }
        }
    }
}