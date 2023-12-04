package alevor87.android.mycityapp.ui

import alevor87.android.mycityapp.data.Datasource
import alevor87.android.mycityapp.data.Datasource.infoForSmallCards
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    onClick: () -> Unit,
    categoryIndex: Int
) {
    Scaffold(
        topBar = {
            MyCityAppBar(info = Datasource.infoForSmallCards[1],
                starterScreen = false)
        }
    ) {it ->
        LazyColumn(contentPadding = it) {
            items(when (categoryIndex) {
                1 -> infoForSmallCards.slice(2..3)
                2 -> infoForSmallCards.slice(4..5)
                else -> infoForSmallCards.slice(0..1)

            }
                    ) {
                    it ->
                SmallCard(
                    cardInfo = it,
                    onClick = onClick,
                    clickIndex = {1})
            }
        }
    }
}

//@Preview
//@Composable
//fun CategoryScreenPreview() {
//    MyCityAppTheme {
//        Surface(
//            color = MaterialTheme.colorScheme.background
//        ) {
//            CategoryScreen()
//        }
//    }
//}


