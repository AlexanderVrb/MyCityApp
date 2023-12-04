package alevor87.android.mycityapp.ui

import alevor87.android.mycityapp.data.Datasource.categoryCards
import alevor87.android.mycityapp.data.MyCityUiState
import alevor87.android.mycityapp.data.SmallCards
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    var categoryIndex by mutableStateOf(0)
        private set

    val updateCategoryIndex= {smallCard: SmallCards ->
        categoryIndex = when (smallCard) {
            categoryCards[0] -> 1
            categoryCards[1] -> 2
            else -> 3
        }
    }
}