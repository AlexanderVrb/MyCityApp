package alevor87.android.mycityapp.main

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.models.SmallCard
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

//    val typeNavigationSelector = { smallCard: SmallCard ->
//        when (smallCard) {
//            Datasource.restaurantCategory ->
//                MyCityScreen.Restaurants.name
//
//            Datasource.theaterCategory ->
//                MyCityScreen.TypeScreen.name
//
//            Datasource.hotelCategory ->
//                MyCityScreen.Hotels.name
//
//            else ->
//                MyCityScreen.Error.name
//        }
//    }
}
