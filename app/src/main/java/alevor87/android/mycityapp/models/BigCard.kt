package alevor87.android.mycityapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BigCard(
    @StringRes val title: Int,
    @DrawableRes val picture: Int,
    @StringRes val description: Int
)