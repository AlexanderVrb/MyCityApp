package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.common.SmallCard
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeScreen(
    navHostController: NavHostController,
    typeId: String?,
    typeViewModel: TypeViewModel = TypeViewModel(),
) {
    typeViewModel.updateTypeUi(typeId?:"Id is not found")
    val typeUiState: TypeUiState by typeViewModel.uiState.collectAsState()
    val toDetailNavigation: (String) -> Unit =
        { detailId -> navHostController.navigate("detail/${detailId}") }

    Scaffold(
        modifier = Modifier.padding(vertical = 12.dp)
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(typeUiState.listOfTypeDetails) {
                SmallCard(
                    navigate = toDetailNavigation,
                    cardInfo = it,
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun TypeScreenPreview() {
//    MyCityAppTheme {
//        Surface(
//            color = MaterialTheme.colorScheme.background
//        ) {
//            TypeScreen(
//                navHostController = rememberNavController(),
//                smallCards = theatersSmallCard,
//                onClick = { TODO("A Filler") },
//                typeName = R.string.theaters
//            )
//        }
//    }
//}
//

