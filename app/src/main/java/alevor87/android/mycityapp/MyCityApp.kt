package alevor87.android.mycityapp

import alevor87.android.mycityapp.main.MainUiState
import alevor87.android.mycityapp.main.MainViewModel
import alevor87.android.mycityapp.detail.DetailUiState
import alevor87.android.mycityapp.detail.DetailViewModel
import alevor87.android.mycityapp.type.TypeUiState
import alevor87.android.mycityapp.type.TypeViewModel
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
    mainViewModel: MainViewModel = viewModel(),
    typeViewModel: TypeViewModel = viewModel(),
    detailViewModel: DetailViewModel = viewModel(),
) {
    val mainUiState: MainUiState by mainViewModel.uiState.collectAsState()

    val typeUiState: TypeUiState by typeViewModel.uiState.collectAsState()

    val detailUiState: DetailUiState by detailViewModel.uiState.collectAsState()

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
            mainUiState = mainUiState,
            typeUiState = typeUiState,
            cityObjectUiState = detailUiState,
            typeNavigationSelector = typeViewModel.detailNavigationSelector,
            detailNavigationSelector = mainViewModel.typeNavigationSelector,
            innerPadding = innerPadding,
            updateTypeUiState = typeViewModel.updateTypeUi,
            updateDetailUi = detailViewModel.updateDetailUi
        )
    }
}