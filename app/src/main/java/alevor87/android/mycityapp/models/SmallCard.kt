package alevor87.android.mycityapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SmallCard(
    val id: String,
    @StringRes val title: Int,
    @DrawableRes val picture: Int
)

