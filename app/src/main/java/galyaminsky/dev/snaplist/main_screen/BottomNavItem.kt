package galyaminsky.dev.snaplist.main_screen

import galyaminsky.dev.snaplist.R

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String,
) {
    object ListItem : BottomNavItem(
        title = "List",
        iconId = R.drawable.icon_list,
        route = "List"
    )

    object NoteItem : BottomNavItem(
        title = "Note",
        iconId = R.drawable.icon_note,
        route = "Note"
    )

    object AboutItem : BottomNavItem(
        title = "About",
        iconId = R.drawable.icon_about,
        route = "About"
    )

    object SettingsItem : BottomNavItem(
        title = "Settings",
        iconId = R.drawable.icon_setting,
        route = "Setting"
    )

}