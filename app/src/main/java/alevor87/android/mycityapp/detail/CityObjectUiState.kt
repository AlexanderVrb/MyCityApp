package alevor87.android.mycityapp.detail

import alevor87.android.mycityapp.Datasource

data class CityObjectUiState(
    val bigTheater: Triple<Int, Int, Int> = Datasource.bigTheater,
    val modernTheater: Triple<Int, Int, Int> = Datasource.modernTheater,
    val saborDeLaVida: Triple<Int, Int, Int> = Datasource.saborDeLaVida,
    val anderson: Triple<Int, Int, Int> = Datasource.anderson,
    val stoleshnikov: Triple<Int, Int, Int> = Datasource.stoleshnikov,
    val intermarkResidence: Triple<Int, Int, Int> = Datasource.intermarkResidence
)