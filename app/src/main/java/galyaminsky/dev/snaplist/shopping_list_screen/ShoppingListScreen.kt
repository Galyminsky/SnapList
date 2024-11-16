package galyaminsky.dev.snaplist.shopping_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import galyaminsky.dev.snaplist.dialog.MainDialog
import galyaminsky.dev.snaplist.ui.theme.LightWhite
import galyaminsky.dev.snaplist.ui.theme.PalletOne_Light
import galyaminsky.dev.snaplist.ui.theme.PalletOne_PurpleLight
import galyaminsky.dev.snaplist.ui.theme.Purple40
import galyaminsky.dev.snaplist.ui.theme.Purple80
import galyaminsky.dev.snaplist.ui.theme.PurpleGrey80


@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel(),
) {
    val itemsList = viewModel.list.collectAsState(initial = emptyList())

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(itemsList.value) { item ->  
            UiShoppingListItem(item) { event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainDialog(viewModel)

}