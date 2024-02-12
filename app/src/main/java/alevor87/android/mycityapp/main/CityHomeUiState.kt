package alevor87.android.mycityapp.main


import alevor87.android.mycityapp.Datasource
import alevor87.android.mycityapp.Datasource.categoryCards
import alevor87.android.mycityapp.models.SmallCard

data class CityHomeUiState(
    val restaurantCategory: SmallCard = Datasource.restaurantCategory,
    val hotelCategory: SmallCard = Datasource.hotelCategory,
    val theaterCategory: SmallCard = Datasource.theaterCategory,
    val cityCategories: List<SmallCard> = categoryCards
)