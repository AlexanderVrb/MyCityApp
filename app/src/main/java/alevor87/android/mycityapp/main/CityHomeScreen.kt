package alevor87.android.mycityapp.main

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.common.SmallCard
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun CityHomeScreen(
    navHostController: NavHostController,
    cardsInfo: List<SmallCard>,
    onClick: (SmallCard) -> String,
) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        items(cardsInfo) {
            SmallCard(
                navHostController = navHostController,
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
                navHostController = rememberNavController(),
                cardsInfo = Datasource.categoryCards,
                onClick = { TODO() }
            )
        }
    }
}