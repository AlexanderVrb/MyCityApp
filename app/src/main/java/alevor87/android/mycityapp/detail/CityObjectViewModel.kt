package alevor87.android.mycityapp.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityObjectViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CityObjectUiState())
    val uiState: StateFlow<CityObjectUiState> = _uiState.asStateFlow()
}