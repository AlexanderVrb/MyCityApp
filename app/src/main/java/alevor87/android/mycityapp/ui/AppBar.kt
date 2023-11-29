@file:OptIn(ExperimentalMaterial3Api::class)

package alevor87.android.mycityapp.ui

import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.data.SmallCards
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun MyCityAppBar(info: SmallCards,
                 starterScreen: Boolean = true,
                 modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (starterScreen) stringResource(R.string.app_bar_app_name)
                    else stringResource(info.title)
                )
            }
        }
    )
}