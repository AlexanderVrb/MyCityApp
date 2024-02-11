package alevor87.android.mycityapp.navigation

import alevor87.android.mycityapp.R
import androidx.annotation.StringRes

enum class MyCityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_bar_app_name),
    Theaters(title = R.string.theaters),
    Restaurants(title = R.string.restaurants),
    Hotels(title = R.string.hotels),
    BigTheater(title = R.string.big_theater_name),
    ModernTheater(title = R.string.modern_theater_name),
    Anderson(title = R.string.anderson_name),
    SaborDeLaVida(title = R.string.sabor_name),
    Stoleshnikov(title = R.string.stoleshnikov_name),
    Intermark(title = R.string.intermark_name),
    Error(title = R.string.error_message )
}