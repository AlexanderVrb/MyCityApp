package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.navigation.MyCityScreen
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TypeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TypeUiState())
    val uiState: StateFlow<TypeUiState> = _uiState.asStateFlow()

    private val typeSelector: (Int) -> List<SmallCard> = { typeName ->
            when (typeName) {
                R.string.theaters ->
                    Datasource.theatersSmallCard
                R.string.restaurants ->
                    Datasource.restaurantsSmallCard
                R.string.hotels ->
                    Datasource.hotelsSmallCards
                else -> Datasource.typeNotFound
            }
    }

    private fun baseUpdateTypeUi(
        typeName: Int,
        typeSelector: (Int) -> List<SmallCard>,
    ) {
        _uiState.update { typeUiState ->
            typeUiState.copy(
                listOfTypeDetails = typeSelector(typeName)
            )
        }
    }

    val updateTypeUi: (Int) -> Unit =
        { typeName -> baseUpdateTypeUi(typeName = typeName, typeSelector = typeSelector) }

    val detailNavigationSelector = { smallCard: SmallCard ->
        try {
            when (smallCard) {
                Datasource.theatersSmallCard[0] ->
                    MyCityScreen.BigTheater.name

                Datasource.theatersSmallCard[1] ->
                    MyCityScreen.ModernTheater.name

                Datasource.restaurantsSmallCard[0] ->
                    MyCityScreen.SaborDeLaVida.name

                Datasource.restaurantsSmallCard[1] ->
                    MyCityScreen.Anderson.name

                Datasource.hotelsSmallCards[0] ->
                    MyCityScreen.Stoleshnikov.name

                Datasource.hotelsSmallCards[1] ->
                    MyCityScreen.Intermark.name

                else ->
                    MyCityScreen.Error.name
            }
        } catch (e: IndexOutOfBoundsException) {
            MyCityScreen.Error.name
        }
    }
}