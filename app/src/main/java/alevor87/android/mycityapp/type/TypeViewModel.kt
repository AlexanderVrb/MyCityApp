package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.models.SmallCard
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TypeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TypeUiState())
    val uiState: StateFlow<TypeUiState> = _uiState.asStateFlow()

    private val typeSelector: (String) -> List<SmallCard> = { typeId ->
            when (typeId) {
                "7" ->
                    Datasource.restaurantsSmallCard
                "8" ->
                    Datasource.hotelsSmallCards
                "9" ->
                    Datasource.theatersSmallCard
                else -> Datasource.typeNotFound
            }
    }

    private fun baseUpdateTypeUi(
        typeId: String,
        typeSelector: (String) -> List<SmallCard>,
    ) {
        _uiState.update { typeUiState ->
            typeUiState.copy(
                listOfTypeDetails = typeSelector(typeId)
            )
        }
    }

    val updateTypeUi: (String) -> Unit =
        { typeId -> baseUpdateTypeUi(typeId = typeId, typeSelector = typeSelector) }

}