package alevor87.android.mycityapp.detail

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.models.BigCard
import alevor87.android.mycityapp.models.SmallCard
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private val detailSelector: (Int) -> BigCard = { detailName ->
        when (detailName) {
            R.string.big_theater_name ->
                Datasource.bigTheater
            R.string.modern_theater_name ->
                Datasource.modernTheater
            R.string.anderson_name ->
                Datasource.anderson
            R.string.sabor_name ->
                Datasource.saborDeLaVida
            R.string.stoleshnikov_name ->
                Datasource.stoleshnikov
            R.string.intermark_name ->
                Datasource.intermarkResidence
            else -> Datasource.detailNotFound
        }
    }

    private fun baseUpdateDetailUi(
        detailName: Int,
        typeSelector: (Int) -> BigCard,
    ) {
        _uiState.update { detailUiState ->
            detailUiState.copy(
                detail = typeSelector(detailName)
            )
        }
    }

    val updateDetailUi: (Int) -> Unit =
        { detailName -> baseUpdateDetailUi(detailName = detailName, typeSelector = detailSelector) }
}