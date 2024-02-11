package alevor87.android.mycityapp

import alevor87.android.mycityapp.cityHome.CityHomeUiState
import alevor87.android.mycityapp.cityHome.CityHomeViewModel
import alevor87.android.mycityapp.cityObject.CityObjectUiState
import alevor87.android.mycityapp.cityObject.CityObjectViewModel
import alevor87.android.mycityapp.cityObjects.CityObjectsUiState
import alevor87.android.mycityapp.cityObjects.CityObjectsViewModel
import alevor87.android.mycityapp.ui.MyCityAppBar
import alevor87.android.mycityapp.navigation.MyCityScreen
import alevor87.android.mycityapp.navigation.Navigation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    navHostController: NavHostController = rememberNavController(),
    cityHomeViewModel: CityHomeViewModel = viewModel(),
    cityObjectsViewModel: CityObjectsViewModel = viewModel(),
    cityObjectViewModel: CityObjectViewModel = viewModel(),
) {
    val cityHomeUiState: CityHomeUiState by cityHomeViewModel.uiState.collectAsState()

    val cityObjectsUiState: CityObjectsUiState by cityObjectsViewModel.uiState.collectAsState()

    val cityObjectUiState: CityObjectUiState by cityObjectViewModel.uiState.collectAsState()

    val backStackEntry by navHostController.currentBackStackEntryAsState()

    val currentScreen = MyCityScreen.valueOf(
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

        Navigation(
            cityHomeUiState = cityHomeUiState,
            cityObjectsUiState = cityObjectsUiState,
            cityObjectUiState = cityObjectUiState,
            objectSelector = cityObjectsViewModel.objectSelector,
            objectsSelector = cityHomeViewModel.objectsSelector,
            innerPadding = innerPadding
        )
    }
}