package alevor87.android.mycityapp.navigation

import alevor87.android.mycityapp.main.MainScreen
import alevor87.android.mycityapp.R
import alevor87.android.mycityapp.common.ErrorScreen
import alevor87.android.mycityapp.detail.DetailScreen
import alevor87.android.mycityapp.type.TypeScreen
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navHostController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navHostController,
        startDestination = "start",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = "start") {
            MainScreen(
                navHostController = navHostController,
                )
        }
        composable(route = "type/{typeId}") {
            TypeScreen(
                typeId = it.arguments?.getString("typeId"),
                navHostController = navHostController,
            )
        }
        composable(route = "detail/{detailId}") {
            val context = LocalContext.current
            DetailScreen(
                detailId = it.arguments?.getString("detailId"),
                onClick =  { text: String -> shareInfo(context, text = text) },
                nickname = stringResource(id = R.string.programmers_nickname)
            )
        }
        composable(route = "error") {
            ErrorScreen()
        }
    }
}

private fun shareInfo(context: Context, text: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.programmers_nickname)
        )
    )
}
