package alevor87.android.mycityapp

import alevor87.android.mycityapp.data.Datasource
import alevor87.android.mycityapp.data.SmallCards
import alevor87.android.mycityapp.ui.CategoryScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import alevor87.android.mycityapp.ui.MyCityAppBar
import alevor87.android.mycityapp.ui.MyCityViewModel
import alevor87.android.mycityapp.ui.SmallCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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

enum class MyCityScreen {
    Start,
    Category,
    Object
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    navHostController: NavHostController = rememberNavController() ,
    myCityViewModel: MyCityViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            MyCityAppBar(info = Datasource.categoryCards[1], starterScreen = true)
        }
    ) { innerPadding ->
        val uiState by myCityViewModel.uiState.collectAsState()

        NavHost(navController = navHostController,
            startDestination =  MyCityScreen.Start.name,
            modifier = Modifier.padding(innerPadding)) {
            composable(route = MyCityScreen.Start.name) {
                MyCityScreen(
                    contentPadding = innerPadding,
                    onClick = {navHostController.navigate(MyCityScreen.Category.name)},
                    clickIndex = myCityViewModel.updateCategoryIndex
                )
            }
            composable(route = MyCityScreen.Category.name) {
                CategoryScreen(
                    onClick = { 3+3 },
                    categoryIndex = myCityViewModel.categoryIndex
                )
            }
        }
    }
}


@Composable
fun MyCityScreen(
    contentPadding: PaddingValues,
    onClick: () -> Unit,
    clickIndex:  (SmallCards) -> Unit
) {
    LazyColumn(contentPadding = contentPadding) {
        items(Datasource.categoryCards) { it ->
            SmallCard(
                cardInfo = it,
                onClick = onClick,
                clickIndex = clickIndex
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