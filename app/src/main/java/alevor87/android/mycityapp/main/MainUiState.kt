package alevor87.android.mycityapp.main


import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.Datasource.categoryCards
import alevor87.android.mycityapp.models.SmallCard

data class MainUiState(
    val cityCategories: List<SmallCard> = categoryCards
)