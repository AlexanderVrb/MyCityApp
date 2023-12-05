package alevor87.android.mycityapp

import alevor87.android.mycityapp.data.Datasource
import alevor87.android.mycityapp.data.MyCityUiState
import alevor87.android.mycityapp.data.SmallCards
import alevor87.android.mycityapp.ui.MyCityAppBar
import alevor87.android.mycityapp.ui.MyCityViewModel
import alevor87.android.mycityapp.ui.ObjectScreen
import alevor87.android.mycityapp.ui.ObjectsScreen
import alevor87.android.mycityapp.ui.SmallCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class MyCityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_bar_app_name),
    Theaters(title = R.string.theaters),
    Restaurants(title = R.string.restaurants),
    Hotels(title = R.string.hotels),
    BigTheater(title = R.string.big_theater_name),
    ModernTheater(title = R.string.modern_theater_name),
    Anderson(title = R.string.anderson_name),
    SaborDeLaVida(title = R.string.sabor_name),
    Stoleshnikov(title = R.string.stoleshnikov_name),
    Intermark(title = R.string.intermark_name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    navHostController: NavHostController = rememberNavController(),
    myCityViewModel: MyCityViewModel = viewModel(),
) {
    val uiState: MyCityUiState by myCityViewModel.uiState.collectAsState()


    val backStackEntry by navHostController.currentBackStackEntryAsState()

    var currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Start.name
    )
    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navHostController.previousBackStackEntry != null,
                navigateUp = { navHostController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = MyCityScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.Start.name) {
                MyCityScreen(
                    onClick = { smallCard: SmallCards ->
                        when (smallCard) {
                            uiState.categoriesUi[2] ->
                                navHostController.navigate(MyCityScreen.Theaters.name)

                            uiState.categoriesUi[1] ->
                                navHostController.navigate(MyCityScreen.Hotels.name)

                            uiState.categoriesUi[0] ->
                                navHostController.navigate(MyCityScreen.Restaurants.name)
                        }
                    },
                    cardsInfo = uiState.categoriesUi
                )
            }
            composable(route = MyCityScreen.Theaters.name) {
                ObjectsScreen(
                    onClick = { smallCard: SmallCards ->
                        when (smallCard) {
                            uiState.listOfTheaterObjects[0] ->
                                navHostController.navigate(MyCityScreen.BigTheater.name)

                            uiState.listOfTheaterObjects[1] ->
                                navHostController.navigate(MyCityScreen.ModernTheater.name)
                        }
                    },
                    smallCards = uiState.listOfTheaterObjects,
                    appBarText = uiState.categoriesUi[2].title
                )
            }
            composable(route = MyCityScreen.Restaurants.name) {
                ObjectsScreen(
                    onClick = { smallCard: SmallCards ->
                        when (smallCard) {
                            uiState.listOfRestaurantObjects[0] ->
                                navHostController.navigate(MyCityScreen.SaborDeLaVida.name)

                            uiState.listOfRestaurantObjects[1] ->
                                navHostController.navigate(MyCityScreen.Anderson.name)
                        }
                    },
                    smallCards = uiState.listOfRestaurantObjects,
                    appBarText = uiState.categoriesUi[0].title
                )
            }
            composable(route = MyCityScreen.Hotels.name) {
                ObjectsScreen(
                    onClick = { smallCard: SmallCards ->
                        when (smallCard) {
                            uiState.listOfHotelObjects[0] ->
                                navHostController.navigate(MyCityScreen.Stoleshnikov.name)

                            uiState.listOfHotelObjects[1] ->
                                navHostController.navigate(MyCityScreen.Intermark.name)
                        }
                    },
                    smallCards = uiState.listOfHotelObjects,
                    appBarText = uiState.categoriesUi[1].title
                )
            }
            composable(route = MyCityScreen.BigTheater.name) {
                val context = LocalContext.current
                ObjectScreen(
                    cardInfo = uiState.objectsUi[0],
                    onClick = { text: String -> shareInfo(context, text = text) },
                    nickname = stringResource(id = R.string.programmers_nickname)
                )
            }
            composable(route = MyCityScreen.ModernTheater.name) {
                val context = LocalContext.current
                ObjectScreen(
                    cardInfo = uiState.objectsUi[1],
                    onClick = { text: String -> shareInfo(context, text = text) },
                    nickname = stringResource(id = R.string.programmers_nickname)
                )
            }
            composable(route = MyCityScreen.SaborDeLaVida.name) {
                val context = LocalContext.current
                ObjectScreen(
                    cardInfo = uiState.objectsUi[2],
                    onClick = { text: String -> shareInfo(context, text = text) },
                    nickname = stringResource(id = R.string.programmers_nickname)
                )
            }
            composable(route = MyCityScreen.Anderson.name) {
                val context = LocalContext.current
                ObjectScreen(
                    cardInfo = uiState.objectsUi[3],
                    onClick = { text: String -> shareInfo(context, text = text) },
                    nickname = stringResource(id = R.string.programmers_nickname)
                )
            }
            composable(route = MyCityScreen.Stoleshnikov.name) {
                val context = LocalContext.current
                ObjectScreen(
                    cardInfo = uiState.objectsUi[4],
                    onClick = { text: String -> shareInfo(context, text = text) },
                    nickname = stringResource(id = R.string.programmers_nickname)
                )
            }
            composable(route = MyCityScreen.Intermark.name) {
                val context = LocalContext.current
                ObjectScreen(
                    cardInfo = uiState.objectsUi[5],
                    onClick = { text: String -> shareInfo(context, text = text) },
                    nickname = stringResource(id = R.string.programmers_nickname)
                )
            }
        }
    }
}


@Composable
fun MyCityScreen(
    cardsInfo: List<SmallCards>,
    onClick: (SmallCards) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        items(cardsInfo) { it ->
            SmallCard(
                cardInfo = it,
                onClick = onClick,

                )
        }
    }
}

private fun shareInfo(context: Context, text: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.programmers_nickname)
        )
    )
}


@Preview
@Composable
fun MyCityScreenPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MyCityScreen(
                cardsInfo = Datasource.categoryCards,
                onClick = {}
            )
        }
    }
}