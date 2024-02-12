package alevor87.android.mycityapp.type

import alevor87.android.mycityapp.Datasource.hotelsSmallCards
import alevor87.android.mycityapp.Datasource.restaurantsSmallCard
import alevor87.android.mycityapp.Datasource.theatersSmallCard
import alevor87.android.mycityapp.models.SmallCard

data class CityObjectsUiState(
    val listOfTheaterObjects: List<SmallCard> = theatersSmallCard,
    val listOfHotelObjects: List<SmallCard> = hotelsSmallCards,
    val listOfRestaurantObjects: List<SmallCard> = restaurantsSmallCard
)