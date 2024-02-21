package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.Datasource.hotelsSmallCards
import alevor87.android.mycityapp.Datasource.restaurantsSmallCard
import alevor87.android.mycityapp.Datasource.theatersSmallCard
import alevor87.android.mycityapp.models.SmallCard

data class TypeUiState(
    var listOfTypeDetails: List<SmallCard> = theatersSmallCard
)