package alevor87.android.mycityapp.cityObject

import alevor87.android.mycityapp.Datasource.infoForBigCards

data class CityObjectUiState(
    val bigTheater: Triple<Int, Int, Int> =
        if (infoForBigCards.size > 0) infoForBigCards[0]
        else infoForBigCards[0],
    val modernTheater: Triple<Int, Int, Int> =
        if (infoForBigCards.size > 1) infoForBigCards[1]
        else infoForBigCards[0],
    val saborDeLaVida: Triple<Int, Int, Int> =
        if (infoForBigCards.size > 2) infoForBigCards[2]
        else infoForBigCards[0],
    val anderson: Triple<Int, Int, Int> =
        if (infoForBigCards.size > 3) infoForBigCards[3]
        else infoForBigCards[0],
    val stoleshnikov: Triple<Int, Int, Int> =
        if (infoForBigCards.size > 4) infoForBigCards[4]
        else infoForBigCards[0],
    val inermarkResidence: Triple<Int, Int, Int> =
        if (infoForBigCards.size > 5) infoForBigCards[5]
        else infoForBigCards[0],
)