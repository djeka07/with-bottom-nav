package com.example.withbottomnav.app.models.navigation

import androidx.annotation.StringRes
import com.example.withbottomnav.R

interface AppDestination {
    val route: String
    val title: Int
    val requireUpNavigation: Boolean
}

object HomeRoute: AppDestination {
    override val route: String = "home"
    @StringRes
    override val title = R.string.home_screen_title
    override val requireUpNavigation = false
}

object ProfileRoute: AppDestination {
    override val route: String = "profile"
    @StringRes
    override val title = R.string.profile_screen_title
    override val requireUpNavigation = false
}

object SettingsRoute: AppDestination {
    override val route: String = "settings"
    @StringRes
    override val title = R.string.settings_screen_title
    override val requireUpNavigation = false
}

object TestRoute: AppDestination {
    override val route: String = "test"
    @StringRes
    override val title = R.string.test_screen_title
    override val requireUpNavigation = false
}

object PageUnderSettingsRoute: AppDestination {
    override val route: String = "pageundersettings"
    @StringRes
    override val title = R.string.page_under_settings_screen_title
    override val requireUpNavigation = false
}