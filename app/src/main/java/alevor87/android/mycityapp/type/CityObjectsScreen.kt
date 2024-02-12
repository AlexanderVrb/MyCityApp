package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.Datasource.theatersSmallCard
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.common.SmallCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectsScreen(
    navHostController: NavHostController,
    smallCards: List<SmallCard>,
    onClick: (SmallCard) -> String,
) {
    Scaffold(
        modifier = Modifier.padding(vertical = 12.dp)
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(smallCards) {
                SmallCard(
                    navHostController = navHostController,
                    cardInfo = it,
                    onClick = onClick,
                )
            }
        }
    }
}

@Preview
@Composable
fun ObjectsScreenPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ObjectsScreen(
                navHostController = rememberNavController(),
                smallCards = theatersSmallCard,
                onClick = { TODO("A Filler") },
            )
        }
    }
}


