package alevor87.android.mycityapp.ui

import alevor87.android.mycityapp.data.Datasource
import alevor87.android.mycityapp.data.Datasource.categoryCards
import alevor87.android.mycityapp.data.Datasource.infoForBigCards
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectScreen() {
    Scaffold(
        topBar = {
            MyCityAppBar(info = categoryCards[1], starterScreen = true)
        }
    ) {
        BigCard(cardInfo = infoForBigCards[1], contentPadding = it)
    }
}

@Preview
@Composable
fun MyCityScreenPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ObjectScreen()
        }
    }
}