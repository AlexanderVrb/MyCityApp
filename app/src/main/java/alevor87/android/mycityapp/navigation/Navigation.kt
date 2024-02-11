package alevor87.android.mycityapp.navigation

import alevor87.android.mycityapp.cityHome.CityHomeScreen
import alevor87.android.mycityapp.cityHome.CityHomeUiState
import alevor87.android.mycityapp.cityObject.CityObjectUiState
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.cityObject.ObjectScreen
import alevor87.android.mycityapp.cityObjects.CityObjectsUiState
import alevor87.android.mycityapp.cityObjects.ObjectsScreen
import alevor87.android.mycityapp.ui.ErrorScreen
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
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController(),
    cityHomeUiState: CityHomeUiState,
    cityObjectsUiState: CityObjectsUiState,
    cityObjectUiState: CityObjectUiState,
    objectSelector: (SmallCard) -> String,
    objectsSelector: (SmallCard) -> String,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = MyCityScreen.Start.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = MyCityScreen.Start.name) {
            CityHomeScreen(
                onClick = { smallCard: SmallCard ->
                    navHostController.navigate(objectsSelector(smallCard))
                },
                cardsInfo = cityHomeUiState.cityCategories
            )
        }
        composable(route = MyCityScreen.Theaters.name) {
            ObjectsScreen(
                onClick = { smallCard: SmallCard ->
                    navHostController.navigate(objectSelector(smallCard))
                },
                smallCards = cityObjectsUiState.listOfTheaterObjects,
            )
        }
        composable(route = MyCityScreen.Restaurants.name) {
            ObjectsScreen(
                onClick = { smallCard: SmallCard ->
                            navHostController.navigate(objectSelector(smallCard))
                },
                smallCards = cityObjectsUiState.listOfRestaurantObjects,
            )
        }
        composable(route = MyCityScreen.Hotels.name) {
            ObjectsScreen(
                onClick = { smallCard: SmallCard ->
                            navHostController.navigate(objectSelector(smallCard))
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
                cardInfo = cityObjectUiState.inermarkResidence,
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
