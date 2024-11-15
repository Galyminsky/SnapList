package galyaminsky.dev.snaplist.new_note_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewNoteScreen () {
    Text(text = "New Note List",
        modifier = Modifier.fillMaxSize()
            .wrapContentWidth()
            .wrapContentHeight()
    )
}