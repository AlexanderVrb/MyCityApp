package alevor87.android.mycityapp.data

import alevor87.android.mycityapp.R

object Datasource {
    val infoForSmallCards = listOf<SmallCards>(
        SmallCards(R.string.big_theater_name, R.drawable.bolshoi_icon),
        SmallCards(R.string.modern_theater_name, R.drawable.modern_icon),
        SmallCards(R.string.sabor_name, R.drawable.sabor_icon),
        SmallCards(R.string.anderson_name, R.drawable.anderson_icon),
        SmallCards(R.string.stoleshnikov_name, R.drawable.stoleshnikov_icon),
        SmallCards(R.string.intermark_name, R.drawable.intermark_icon)
    )

    val categoryCards = listOf<SmallCards>(
        SmallCards(R.string.restaurants, R.drawable.restaurant_category),
        SmallCards(R.string.hotels, R.drawable.hotel_category),
        SmallCards(R.string.theaters, R.drawable.theater_category)
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

//    val allCategories = listOf(
//        Pair(R.string.restaurants, R.drawable.restaurant_category),
//        Pair(R.string.hotels, R.drawable.hotel_category),
//        Pair(R.string.theaters, R.drawable.theater_category)
//    )
//
//    val theatersCategory = listOf(
//        Pair(R.string.big_theater_name, R.drawable.bolshoi_icon),
//        Pair(R.string.modern_theater_name, R.drawable.modern_icon)
//    )
//
//    val restaurantsCategory = listOf(
//        Pair(R.string.sabor_name, R.drawable.sabor_icon),
//        Pair(R.string.anderson_name, R.drawable.anderson_icon)
//    )
//
//    val hotelsCategory = listOf(
//        Pair(R.string.stoleshnikov_name, R.drawable.stoleshnikov_icon),
//        Pair(R.string.intermark_name, R.drawable.intermark_icon)
//    )
//
//    val theaters = listOf(
//        Triple(R.string.big_theater_name, R.drawable.bolshoi_pic,
//            R.string.big_theater_description),
//        Triple(R.string.modern_theater_name, R.drawable.modern_pic,
//            R.string.modern_theater_description)
//    )
//
//    val restaurants = listOf(
//        Triple(R.string.sabor_name, R.drawable.sabor_pic,
//            R.string.sabor_descriptions),
//        Triple(R.string.anderson_name, R.drawable.anderson_pic,
//            R.string.anderson_description)
//    )
//
//    val hotels = listOf(
//        Triple(R.string.stoleshnikov_name, R.drawable.sabor_pic,
//            R.string.stoleshnikov_description),
//        Triple(R.string.intermark_name, R.drawable.intermark_pic,
//            R.string.intermark_description)
//    )
}