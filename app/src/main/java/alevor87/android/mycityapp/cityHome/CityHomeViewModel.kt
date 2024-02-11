package alevor87.android.mycityapp.cityHome

import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.navigation.MyCityScreen
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityHomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CityHomeUiState())
    val uiState: StateFlow<CityHomeUiState> = _uiState.asStateFlow()

    val objectsSelector = { smallCard: SmallCard ->
        when (smallCard) {
            uiState.value.restaurantCategory ->
                MyCityScreen.Restaurants.name

            uiState.value.theaterCategory ->
                MyCityScreen.Theaters.name

            uiState.value.hotelCategory ->
                MyCityScreen.Hotels.name

            else ->
                MyCityScreen.Error.name
        }
    }
}
