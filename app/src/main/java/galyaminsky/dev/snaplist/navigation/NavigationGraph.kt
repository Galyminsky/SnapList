package galyaminsky.dev.snaplist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import galyaminsky.dev.snaplist.about_screen.AboutScreen
import galyaminsky.dev.snaplist.note_list_screen.NoteListScreen
import galyaminsky.dev.snaplist.setting_screen.SettingScreen
import galyaminsky.dev.snaplist.shopping_list_screen.ShoppingListScreen
import galyaminsky.dev.snaplist.utils.Routes

@Composable
fun NavigationGraph (navController: NavHostController, onNavigate: (String) -> Unit) {


    NavHost(navController = navController, startDestination = Routes.SHOPPING_LIST) {
        composable(Routes.SHOPPING_LIST) {
            ShoppingListScreen() { route ->
                onNavigate(route)
            }
        }
        composable(Routes.NOTE_LIST) {
            NoteListScreen()
        }
        composable(Routes.ABOUT) {
            AboutScreen()
        }
        composable(Routes.SETTINGS) {
            SettingScreen()
        }
    }
}