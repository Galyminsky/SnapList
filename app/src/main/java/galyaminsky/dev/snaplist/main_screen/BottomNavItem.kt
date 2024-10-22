package galyaminsky.dev.snaplist.main_screen

import galyaminsky.dev.snaplist.R
import galyaminsky.dev.snaplist.utils.Routes

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String,
) {
    object ListItem : BottomNavItem(
        title = "List",
        iconId = R.drawable.icon_list,
        route = Routes.SHOPPING_LIST
    )

    object NoteItem : BottomNavItem(
        title = "Note",
        iconId = R.drawable.icon_note,
        route = Routes.NOTE_LIST
    )

    object AboutItem : BottomNavItem(
        title = "About",
        iconId = R.drawable.icon_about,
        route = Routes.ABOUT
    )

    object SettingsItem : BottomNavItem(
        title = "Settings",
        iconId = R.drawable.icon_setting,
        route = Routes.SETTINGS
    )

}