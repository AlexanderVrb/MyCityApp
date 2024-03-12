package alevor87.android.mycityapp.main

import alevor87.android.mycityapp.common.SmallCard
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    navHostController: NavHostController,
    mainViewModel: MainViewModel = MainViewModel(),
) {
    val mainUiState: MainUiState by mainViewModel.uiState.collectAsState()
    val toTypeScreenNavigation: (String) -> Unit =
        { typeId -> navHostController.navigate("type/${typeId}")}

    LazyColumn(
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        items(mainUiState.cityCategories) {
            SmallCard(
                navigate = toTypeScreenNavigation,
                cardInfo = it,
            )
        }
    }
}


//@Preview
//@Composable
//fun MainScreenPreview() {
//    MyCityAppTheme {
//        Surface(
//            color = MaterialTheme.colorScheme.background
//        ) {
//            MainScreen(
//                navHostController = rememberNavController(),
//                cardsInfo = Datasource.categoryCards,
//                onClick = { TODO() }
//            )
//        }
//    }
//}