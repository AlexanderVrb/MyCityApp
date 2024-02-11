package alevor87.android.mycityapp.cityHome

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.ui.SmallCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityHomeScreen(
    cardsInfo: List<SmallCard>,
    onClick: (SmallCard) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        items(cardsInfo) {
            SmallCard(
                cardInfo = it,
                onClick = onClick
            )
        }
    }
}


@Preview
@Composable
fun CityHomeScreenPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            CityHomeScreen(
                cardsInfo = Datasource.categoryCards,
                onClick = {}
            )
        }
    }
}