package alevor87.android.mycityapp.data

import alevor87.android.mycityapp.data.Datasource.categoryCards
import alevor87.android.mycityapp.data.Datasource.infoForBigCards
import alevor87.android.mycityapp.data.Datasource.infoForSmallCards
import java.util.EventObject

data class MyCityUiState(
    var categoriesUi: List<SmallCards> = categoryCards,
    var objectsUi: List<Triple<Int, Int, Int>> = infoForBigCards,
    var listOfTheaterObjects: List<SmallCards> = infoForSmallCards.slice(0..1),
    var listOfHotelObjects: List<SmallCards> = infoForSmallCards.slice(4..5),
    var listOfRestaurantObjects: List<SmallCards> = infoForSmallCards.slice(2..3)
)