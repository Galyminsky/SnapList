package galyaminsky.dev.snaplist.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import galyaminsky.dev.snaplist.R
import galyaminsky.dev.snaplist.ui.theme.PalletOne_PurpleLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        floatingActionButton = {
            Box(
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = { },
                    containerColor = PalletOne_PurpleLight,
                    shape = CircleShape,
                    modifier = androidx.compose.ui.Modifier
                        .size(50.dp)
                        .offset(y = 40.dp)
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.icon_add
                        ),
                        contentDescription = "Add icon",
                        tint = Color.White
                    )
                }
            }
        },
        bottomBar = {
            BottomNav()
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {

    }
}