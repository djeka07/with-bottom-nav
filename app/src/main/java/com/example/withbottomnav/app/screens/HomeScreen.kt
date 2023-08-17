package com.example.withbottomnav.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.withbottomnav.R
import com.example.withbottomnav.app.models.navigation.HomeRoute


@Composable
fun HomeScreen() {
    Column {
        Text(
            stringResource(id = R.string.home_screen_title),
            style = MaterialTheme.typography.displayMedium
        )
    }
}

fun NavGraphBuilder.addHomeRoute() {
    composable(
        route = HomeRoute.route,
    ) {
        HomeScreen()
    }
}