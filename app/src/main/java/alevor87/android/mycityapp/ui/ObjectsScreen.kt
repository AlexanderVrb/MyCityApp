package alevor87.android.mycityapp.ui

import alevor87.android.mycityapp.data.Datasource
import alevor87.android.mycityapp.data.SmallCards
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectsScreen(
    smallCards: List<SmallCards>,
    onClick: (SmallCards) -> Unit,
) {
    Scaffold(
        modifier = Modifier.padding(vertical = 12.dp)
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(smallCards) {
                SmallCard(
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
                smallCards = Datasource.infoForSmallCards.slice(0..1),
                onClick = { TODO("A Filler") },
            )
        }
    }
}


