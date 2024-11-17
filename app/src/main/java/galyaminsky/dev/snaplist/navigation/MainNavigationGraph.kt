package galyaminsky.dev.snaplist.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import galyaminsky.dev.snaplist.add_item_screen.AddItemScreen
import galyaminsky.dev.snaplist.main_screen.MainScreen
import galyaminsky.dev.snaplist.new_note_screen.NewNoteScreen
import galyaminsky.dev.snaplist.utils.Routes

@Composable
fun MainNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.ADD_ITEM + "/{listId}") {
            AddItemScreen()
        }
        composable(Routes.NEW_NOTE) {
            NewNoteScreen()
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }

    }
}