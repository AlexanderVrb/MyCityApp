package alevor87.android.mycityapp

import alevor87.android.mycityapp.models.BigCard
import alevor87.android.mycityapp.models.SmallCard

object Datasource {
    val theatersSmallCard = listOf(
        SmallCard("1", R.string.big_theater_name, R.drawable.bolshoi_icon),
        SmallCard("2", R.string.modern_theater_name, R.drawable.modern_icon),
    )

    val restaurantsSmallCard = listOf(
        SmallCard("3", R.string.sabor_name, R.drawable.sabor_icon),
        SmallCard("4", R.string.anderson_name, R.drawable.anderson_icon)
    )

    val hotelsSmallCards = listOf(
        SmallCard("5", R.string.stoleshnikov_name, R.drawable.stoleshnikov_icon),
        SmallCard("6", R.string.intermark_name, R.drawable.intermark_icon)
    )

    val typeNotFound = listOf(SmallCard("0", R.string.type_not_found, R.drawable.image_not_found ))

    val detailNotFound =
        BigCard("0",
            R.string.detail_error_message,
            R.drawable.image_not_found,
            R.string.detail_error_message)

    val categoryCards = listOf(
        SmallCard("7", R.string.restaurants, R.drawable.restaurant_category),
        SmallCard("8", R.string.hotels, R.drawable.hotel_category),
        SmallCard("9", R.string.theaters, R.drawable.theater_category)
    )

    val restaurantCategory = SmallCard("7", R.string.restaurants, R.drawable.restaurant_category)
    val hotelCategory = SmallCard("8", R.string.hotels, R.drawable.hotel_category)
    val theaterCategory = SmallCard("9", R.string.theaters, R.drawable.theater_category)

    val bigTheater = BigCard("1", R.string.big_theater_name, R.drawable.bolshoi_pic,
        R.string.big_theater_description)
    val modernTheater = BigCard("2", R.string.modern_theater_name, R.drawable.modern_pic,
        R.string.modern_theater_description)
    val saborDeLaVida = BigCard("3", R.string.sabor_name, R.drawable.sabor_pic,
        R.string.sabor_descriptions)
    val anderson = BigCard("4", R.string.anderson_name, R.drawable.anderson_pic,
        R.string.anderson_description)
    val stoleshnikov = BigCard("5", R.string.stoleshnikov_name, R.drawable.sabor_pic,
        R.string.stoleshnikov_description)
    val intermarkResidence = BigCard("6", R.string.intermark_name, R.drawable.intermark_pic,
        R.string.intermark_description)
}