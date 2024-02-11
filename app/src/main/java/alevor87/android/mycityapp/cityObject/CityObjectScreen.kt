package alevor87.android.mycityapp.cityObject

import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.Datasource.infoForBigCards
import alevor87.android.mycityapp.ui.BigCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectScreen(
    cardInfo: Triple<Int, Int, Int>,
    onClick: (String) -> Unit,
    nickname: String,
) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { onClick(nickname) }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { it ->
            BigCard(cardInfo = cardInfo, contentPadding = it)
        }
    }
}

@Preview
@Composable
fun MyCityScreenPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ObjectScreen(
                cardInfo =
                if (infoForBigCards.size > 1) infoForBigCards[1]
                else infoForBigCards[0],
                onClick = { TODO() },
                nickname = stringResource(R.string.programmers_nickname)
            )
        }
    }
}
