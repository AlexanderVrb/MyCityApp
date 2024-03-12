package alevor87.android.mycityapp.common

import alevor87.android.mycityapp.Datasource.bigTheater
import alevor87.android.mycityapp.Datasource.theatersSmallCard
import alevor87.android.mycityapp.models.BigCard
import alevor87.android.mycityapp.models.SmallCard
import alevor87.android.mycityapp.ui.theme.MyCityAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallCard(
    navigate: (String) -> Unit,
    cardInfo: SmallCard,
//    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 16.dp)
                .clickable {
                    navigate(cardInfo.id)
                }
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(cardInfo.picture),
                    alignment = Alignment.TopCenter,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Column {
                Text(
                    text = stringResource(cardInfo.title),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(32.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun SmallCardPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SmallCard(
                cardInfo = theatersSmallCard[1],
                navigate = { TODO() }
            )
        }
    }
}

@Composable
fun BigCard(
//  modifier: Modifier = Modifier,
    bigCard: BigCard,
    contentPadding: PaddingValues,
//  contentPadding: PaddingValues = PaddingValues(16.dp),
) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(bigCard.picture),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .padding(vertical = 8.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(bigCard.description),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun BigCardPreview() {
    MyCityAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BigCard(
                bigCard = bigTheater,
                contentPadding = PaddingValues(16.dp)
            )
        }
    }
}