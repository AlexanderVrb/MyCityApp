package alevor87.android.mycityapp.cityHome

import alevor87.android.mycityapp.Datasource.categoryCards
import alevor87.android.mycityapp.models.SmallCard

data class CityHomeUiState(
    val restaurantCategory: SmallCard =
        if (categoryCards.size > 0) categoryCards[0] else categoryCards[0],
    val hotelCategory: SmallCard =
        if (categoryCards.size > 1) categoryCards[1] else categoryCards[0],
    val theaterCategory: SmallCard =
        if (categoryCards.size > 2) categoryCards[2] else categoryCards[0],
    val cityCategories: List<SmallCard> = categoryCards
)