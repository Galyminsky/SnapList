package galyaminsky.dev.snaplist.add_item_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddItemScreen () {
    Text(text = "Add Item List",
        modifier = Modifier.fillMaxSize()
            .wrapContentWidth()
            .wrapContentHeight()
    )
}