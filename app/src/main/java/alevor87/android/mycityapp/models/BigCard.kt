package alevor87.android.mycityapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes

data class BigCard(
    val id: String,
    @StringRes val title: Int,
    @DrawableRes val picture: Int,
    @StringRes val description: Int
)