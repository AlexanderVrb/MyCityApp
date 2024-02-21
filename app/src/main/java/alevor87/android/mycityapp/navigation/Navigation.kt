package alevor87.android.mycityapp.navigation

import alevor87.android.mycityapp.main.MainScreen
import alevor87.android.mycityapp.main.MainUiState
import alevor87.android.mycityapp.detail.DetailUiState
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.detail.DetailScreen
import alevor87.android.mycityapp.type.TypeUiState
import alevor87.android.mycityapp.type.TypeScreen
import alevor87.android.mycityapp.common.ErrorScreen
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navHostController: NavHostController,
    mainUiState: MainUiState,
    typeUiState: TypeUiState,
    cityObjectUiState: DetailUiState,
    typeNavigationSelector: (SmallCard) -> String,
    updateTypeUiState: (Int) -> Unit,
    detailNavigationSelector: (SmallCard) -> String,
    updateDetailUi: (Int) -> Unit,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navHostController,
        startDestination = MyCityScreen.Start.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = MyCityScreen.Start.name) {
            MainScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    detailNavigationSelector(smallCard)
                },
                cardsInfo = mainUiState.cityCategories,
                updateTypeUiState = updateTypeUiState

            )
        }
        composable(route = MyCityScreen.Theaters.name) {
            TypeScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    typeNavigationSelector(smallCard)
                },
                smallCards = typeUiState.listOfTypeDetails,
                typeName = R.string.theaters,
                updateTypeUiState = updateDetailUi
            )
        }
        composable(route = MyCityScreen.Restaurants.name) {
            TypeScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    typeNavigationSelector(smallCard)
                },
                smallCards = typeUiState.listOfTypeDetails,
                typeName = R.string.restaurants,
                updateTypeUiState = updateDetailUi
            )
        }
        composable(route = MyCityScreen.Hotels.name) {
            TypeScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    typeNavigationSelector(smallCard)
                },
                smallCards = typeUiState.listOfTypeDetails,
                typeName = R.string.hotels,
                updateTypeUiState = updateDetailUi
            )
        }
        composable(route = MyCityScreen.BigTheater.name) {
            val context = LocalContext.current
            DetailScreen(
                bigCard = cityObjectUiState.detail,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.ModernTheater.name) {
            val context = LocalContext.current
            DetailScreen(
                bigCard = cityObjectUiState.detail,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.SaborDeLaVida.name) {
            val context = LocalContext.current
            DetailScreen(
                bigCard = cityObjectUiState.detail,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Anderson.name) {
            val context = LocalContext.current
            DetailScreen(
                bigCard = cityObjectUiState.detail,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Stoleshnikov.name) {
            val context = LocalContext.current
            DetailScreen(
                bigCard = cityObjectUiState.detail,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Intermark.name) {
            val context = LocalContext.current
            DetailScreen(
                bigCard = cityObjectUiState.detail,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Error.name) {
            ErrorScreen()
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
