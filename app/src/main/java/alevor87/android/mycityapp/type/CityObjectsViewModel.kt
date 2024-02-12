package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.navigation.MyCityScreen
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityObjectsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CityObjectsUiState())
    val uiState: StateFlow<CityObjectsUiState> = _uiState.asStateFlow()

    val objectSelector = { smallCard: SmallCard ->
        try {
            when (smallCard) {
                uiState.value.listOfTheaterObjects[0] ->
                    MyCityScreen.BigTheater.name

                uiState.value.listOfTheaterObjects[1] ->
                    MyCityScreen.ModernTheater.name

                uiState.value.listOfRestaurantObjects[0] ->
                    MyCityScreen.SaborDeLaVida.name

                uiState.value.listOfRestaurantObjects[1] ->
                    MyCityScreen.Anderson.name

                uiState.value.listOfHotelObjects[0] ->
                    MyCityScreen.Stoleshnikov.name

                uiState.value.listOfHotelObjects[1] ->
                    MyCityScreen.Intermark.name

                else ->
                    MyCityScreen.Error.name
            }
        } catch (e: IndexOutOfBoundsException) {
            MyCityScreen.Error.name
        }
    }
}