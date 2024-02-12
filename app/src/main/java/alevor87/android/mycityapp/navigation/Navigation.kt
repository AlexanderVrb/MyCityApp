package alevor87.android.mycityapp.navigation

import alevor87.android.mycityapp.main.CityHomeScreen
import alevor87.android.mycityapp.main.CityHomeUiState
import alevor87.android.mycityapp.detail.CityObjectUiState
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.detail.ObjectScreen
import alevor87.android.mycityapp.type.CityObjectsUiState
import alevor87.android.mycityapp.type.ObjectsScreen
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
    cityHomeUiState: CityHomeUiState,
    cityObjectsUiState: CityObjectsUiState,
    cityObjectUiState: CityObjectUiState,
    objectSelector: (SmallCard) -> String,
    objectsSelector: (SmallCard) -> String,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navHostController,
        startDestination = MyCityScreen.Start.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = MyCityScreen.Start.name) {
            CityHomeScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    objectsSelector(smallCard)
                },
                cardsInfo = cityHomeUiState.cityCategories
            )
        }
        composable(route = MyCityScreen.Theaters.name) {
            ObjectsScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    objectSelector(smallCard)
                },
                smallCards = cityObjectsUiState.listOfTheaterObjects,
            )
        }
        composable(route = MyCityScreen.Restaurants.name) {
            ObjectsScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    objectSelector(smallCard)
                },
                smallCards = cityObjectsUiState.listOfRestaurantObjects,
            )
        }
        composable(route = MyCityScreen.Hotels.name) {
            ObjectsScreen(
                navHostController = navHostController,
                onClick = { smallCard: SmallCard ->
                    objectSelector(smallCard)
                },
                smallCards = cityObjectsUiState.listOfHotelObjects,
            )
        }
        composable(route = MyCityScreen.BigTheater.name) {
            val context = LocalContext.current
            ObjectScreen(
                cardInfo = cityObjectUiState.bigTheater,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.ModernTheater.name) {
            val context = LocalContext.current
            ObjectScreen(
                cardInfo = cityObjectUiState.modernTheater,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.SaborDeLaVida.name) {
            val context = LocalContext.current
            ObjectScreen(
                cardInfo = cityObjectUiState.saborDeLaVida,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Anderson.name) {
            val context = LocalContext.current
            ObjectScreen(
                cardInfo = cityObjectUiState.anderson,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Stoleshnikov.name) {
            val context = LocalContext.current
            ObjectScreen(
                cardInfo = cityObjectUiState.stoleshnikov,
                onClick = { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = MyCityScreen.Intermark.name) {
            val context = LocalContext.current
            ObjectScreen(
                cardInfo = cityObjectUiState.intermarkResidence,
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
