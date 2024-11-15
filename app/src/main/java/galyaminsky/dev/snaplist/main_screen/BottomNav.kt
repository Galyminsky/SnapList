package galyaminsky.dev.snaplist.main_screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import galyaminsky.dev.snaplist.ui.theme.PalletOne_PurpleLight

@Composable
fun BottomNav(navController: NavHostController) {

    val listItems = listOf(
        BottomNavItem.ListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingsItem,
    )
    BottomNavigation(
        backgroundColor = Color.White, modifier = Modifier
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        listItems.forEach { bottomNavItem ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            BottomNavigationItem(
                selected = currentRoute == bottomNavItem.route,
                onClick = {
                    navController.navigate(bottomNavItem.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = bottomNavItem.iconId
                        ),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(text = bottomNavItem.title)
                },
                selectedContentColor = PalletOne_PurpleLight,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false

            )
        }
    }
}