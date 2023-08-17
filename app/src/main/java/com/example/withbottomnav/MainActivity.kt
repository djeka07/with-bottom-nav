package com.example.withbottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.withbottomnav.app.components.navigations.BottomBar
import com.example.withbottomnav.app.models.navigation.HomeRoute
import com.example.withbottomnav.app.models.navigation.SettingsRoute
import com.example.withbottomnav.app.screens.addHomeRoute
import com.example.withbottomnav.app.screens.addPageUnderSettingsRoute
import com.example.withbottomnav.app.screens.addProfileRoute
import com.example.withbottomnav.app.screens.addSettingsRoute
import com.example.withbottomnav.app.screens.addTestRoute
import com.example.withbottomnav.ui.theme.WithBottomNavTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WithBottomNavTheme {
                Scaffold(
                    bottomBar = { BottomBar(navController = navController) }
                ) { padding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(navController = navController, startDestination = HomeRoute.route) {
                            addHomeRoute()
                            addProfileRoute()
                            addTestRoute(navController = navController)
                            addSecondNav(baseNavController = navController)
                        }
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.addSecondNav(baseNavController: NavHostController) {
        composable(
            route = SettingsRoute.route,
            exitTransition = {
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
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = SettingsRoute.route) {
                addSettingsRoute(
                    baseNavController = baseNavController,
                    navController = navController
                )
                addPageUnderSettingsRoute(navController = navController)
            }
        }
    }
}