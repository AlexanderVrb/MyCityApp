package alevor87.android.mycityapp.detail

import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.models.BigCard

data class DetailUiState(
    val detail: BigCard = Datasource.bigTheater
)