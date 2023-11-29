package alevor87.android.mycityapp

import alevor87.android.mycityapp.data.Datasource
import androidx.lifecycle.viewmodel.compose.viewModel
import alevor87.android.mycityapp.ui.MyCityAppBar
import alevor87.android.mycityapp.ui.MyCityViewModel
import alevor87.android.mycityapp.ui.SmallCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
) {
    Scaffold(
        topBar = {
            MyCityAppBar(info = Datasource.categoryCards[1], starterScreen = true)
        }
    ) { innerPadding ->
        MyCityScreen(contentPadding = innerPadding)
    }
}


@Composable
fun MyCityScreen(
    contentPadding: PaddingValues,
) {
    LazyColumn(contentPadding = contentPadding) {
        items(Datasource.categoryCards) { it ->
            SmallCard(
                cardInfo = it
            )
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
            MyCityApp()
        }
    }
}