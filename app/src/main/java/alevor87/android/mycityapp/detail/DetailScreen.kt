package alevor87.android.mycityapp.detail

import alevor87.android.mycityapp.Datasource.bigTheater
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.common.BigCard
import alevor87.android.mycityapp.models.BigCard
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    detailId: String?,
    detailViewModel: DetailViewModel = DetailViewModel(),
    onClick: (String) -> Unit,
    nickname: String
) {
    detailViewModel.updateDetailUi(detailId?:"Id is not found")
    val detailUiState: DetailUiState by detailViewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { onClick(nickname) } ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { it ->
            BigCard(bigCard = detailUiState.detail, contentPadding = it)
        }
    }
}

//@Preview
//@Composable
//fun DetailScreenPreview() {
//    MyCityAppTheme {
//        Surface(
//            color = MaterialTheme.colorScheme.background
//        ) {
//            DetailScreen(
//                bigCard =
//                bigTheater,
//                onClick = { TODO() },
//                nickname = stringResource(R.string.programmers_nickname)
//            )
//        }
//    }
//}
