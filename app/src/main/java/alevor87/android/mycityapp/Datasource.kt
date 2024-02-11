package alevor87.android.mycityapp

import alevor87.android.mycityapp.models.SmallCard

object Datasource {
    val theatersSmallCard = listOf(
        SmallCard(R.string.big_theater_name, R.drawable.bolshoi_icon),
        SmallCard(R.string.modern_theater_name, R.drawable.modern_icon),
    )

    val restaurantsSmallCard = listOf(
        SmallCard(R.string.sabor_name, R.drawable.sabor_icon),
        SmallCard(R.string.anderson_name, R.drawable.anderson_icon)
    )

    val hotelsSmallCards = listOf(
        SmallCard(R.string.stoleshnikov_name, R.drawable.stoleshnikov_icon),
        SmallCard(R.string.intermark_name, R.drawable.intermark_icon)
    )

    val categoryCards = listOf(
        SmallCard(R.string.restaurants, R.drawable.restaurant_category),
        SmallCard(R.string.hotels, R.drawable.hotel_category),
        SmallCard(R.string.theaters, R.drawable.theater_category)
    )

    val infoForBigCards = listOf(
        Triple(R.string.big_theater_name, R.drawable.bolshoi_pic,
            R.string.big_theater_description),
        Triple(R.string.modern_theater_name, R.drawable.modern_pic,
            R.string.modern_theater_description),
        Triple(R.string.sabor_name, R.drawable.sabor_pic,
            R.string.sabor_descriptions),
        Triple(R.string.anderson_name, R.drawable.anderson_pic,
            R.string.anderson_description),
        Triple(R.string.stoleshnikov_name, R.drawable.sabor_pic,
            R.string.stoleshnikov_description),
        Triple(R.string.intermark_name, R.drawable.intermark_pic,
            R.string.intermark_description)
    )
}