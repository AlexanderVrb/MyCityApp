package alevor87.android.mycityapp.data

import alevor87.android.mycityapp.data.Datasource.categoryCards
import alevor87.android.mycityapp.data.Datasource.infoForBigCards
import alevor87.android.mycityapp.data.Datasource.infoForSmallCards
import java.util.EventObject

data class MyCityUiState(
    val categoriesUi: List<SmallCards> = categoryCards,
    val objectsUi: List<Triple<Int, Int, Int>> = infoForBigCards,
    val listOfTheaterObjects: List<SmallCards> = infoForSmallCards.slice(0..1),
    val listOfHotelObjects: List<SmallCards> = infoForSmallCards.slice(4..5),
    val listOfRestaurantObjects: List<SmallCards> = infoForSmallCards.slice(2..3),
)