package alevor87.android.mycityapp.ui

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
    myCityViewModel: MyCityViewModel = viewModel()
) {
    val myCityUiState by myCityViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            MyCityAppBar(info = myCityUiState.listOfTheaterObjects[1], starterScreen = false)
        }
    ) {it ->
        LazyColumn(contentPadding = it) {
            items(myCityUiState.listOfTheaterObjects) { listOfTheaterObjects ->
                SmallCard(cardInfo = listOfTheaterObjects)
            }
        }
    }
}

@Preview
@Composable
fun CategoryScreenPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            CategoryScreen()
        }
    }
}


