package alevor87.android.mycityapp

import alevor87.android.mycityapp.main.CityHomeUiState
import alevor87.android.mycityapp.main.CityHomeViewModel
import alevor87.android.mycityapp.detail.CityObjectUiState
import alevor87.android.mycityapp.detail.CityObjectViewModel
import alevor87.android.mycityapp.type.CityObjectsUiState
import alevor87.android.mycityapp.type.CityObjectsViewModel
import alevor87.android.mycityapp.common.widgets.MyCityAppBar
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
            navHostController = navHostController,
            cityHomeUiState = cityHomeUiState,
            cityObjectsUiState = cityObjectsUiState,
            cityObjectUiState = cityObjectUiState,
            objectSelector = cityObjectsViewModel.objectSelector,
            objectsSelector = cityHomeViewModel.objectsSelector,
            innerPadding = innerPadding
        )
    }
}