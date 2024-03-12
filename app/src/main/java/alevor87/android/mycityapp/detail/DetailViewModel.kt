package alevor87.android.mycityapp.detail

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.models.BigCard
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private val detailSelector: (String) -> BigCard = { detailId ->
        when (detailId) {
            "1" ->
                Datasource.bigTheater
            "2" ->
                Datasource.modernTheater
            "3" ->
                Datasource.saborDeLaVida
            "4" ->
                Datasource.anderson
            "5" ->
                Datasource.stoleshnikov
            "6" ->
                Datasource.intermarkResidence
            else -> Datasource.detailNotFound
        }
    }

    private fun baseUpdateDetailUi(
        detailId: String,
        typeSelector: (String) -> BigCard,
    ) {
        _uiState.update { detailUiState ->
            detailUiState.copy(
                detail = typeSelector(detailId)
            )
        }
    }

    fun updateDetailUi(detailId: String): Unit =
        baseUpdateDetailUi(detailId = detailId, typeSelector = detailSelector)
}