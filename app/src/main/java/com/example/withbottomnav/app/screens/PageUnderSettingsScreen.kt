package com.example.withbottomnav.app.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.withbottomnav.R
import com.example.withbottomnav.app.models.navigation.PageUnderSettingsRoute

@Composable
fun PageUnderSettingsScreen(onBackClick: () -> Unit) {
    Column {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(
            stringResource(id = R.string.page_under_settings_screen_title),
            style = MaterialTheme.typography.displayMedium
        )
    }
}

fun NavGraphBuilder.addPageUnderSettingsRoute(navController: NavHostController) {
    composable(
        route = PageUnderSettingsRoute.route,exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ) {
        PageUnderSettingsScreen(onBackClick = { navController.navigateUp() })
    }
}