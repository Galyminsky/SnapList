package galyaminsky.dev.snaplist.shopping_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import galyaminsky.dev.snaplist.R
import galyaminsky.dev.snaplist.data.ShoppingListItem
import galyaminsky.dev.snaplist.ui.theme.DarkText
import galyaminsky.dev.snaplist.ui.theme.LightText
import galyaminsky.dev.snaplist.ui.theme.PalletOne_PurpleLight
import galyaminsky.dev.snaplist.ui.theme.Pink80
import galyaminsky.dev.snaplist.ui.theme.Purple80
import galyaminsky.dev.snaplist.ui.theme.PurpleGrey80
import galyaminsky.dev.snaplist.utils.Routes


@Composable
fun UiShoppingListItem(
    item: ShoppingListItem, onEvent: (ShoppingListEvent) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 3.dp, top = 18.dp, end = 3.dp
        )
    ) {
        val (card, deleteButton, editButton, counter) = createRefs()
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .constrainAs(card) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .clickable {
                onEvent(ShoppingListEvent.OnItemClick(
                    Routes.ADD_ITEM + "/${item.id}"
                ))
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = item.name,
                    style = TextStyle(
                        color = DarkText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = item.time,
                    style = TextStyle(
                        color = LightText,
                        fontSize = 14.sp
                    )
                )
                LinearProgressIndicator(
                    progress = { 0.5f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    color = PalletOne_PurpleLight,
                )

            }
        }
        IconButton(
            onClick = {
                onEvent(ShoppingListEvent.OnShowDeleteDialog(item))
            },
            modifier = Modifier
                .constrainAs(deleteButton) {
                    top.linkTo(card.top)
                    end.linkTo(card.end)
                    bottom.linkTo(card.top)
                }
                .padding(end = 10.dp)
                .size(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_delete),
                contentDescription = "buttonDelete",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Pink80)
                    .padding(5.dp),

                )
        }
        IconButton(
            onClick = {
                onEvent(ShoppingListEvent.OnShowEditDialog(item))
            },
            modifier = Modifier
                .constrainAs(editButton) {
                    top.linkTo(card.top)
                    end.linkTo(deleteButton.start)
                    bottom.linkTo(card.top)
                }
                .padding(end = 5.dp)
                .size(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_edit),
                contentDescription = "buttonEdit",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(PurpleGrey80)
                    .padding(5.dp),
                tint = Color.White
            )
        }
        Card(shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .constrainAs(counter) {
                    top.linkTo(card.top)
                    end.linkTo(editButton.start)
                    bottom.linkTo(card.top)
                }
                .padding(end = 5.dp)
        ) {
            Text(
                text = "${item.allItemCount} / ${item.allSelectedItemCount}",
                modifier = Modifier
                    .background(Purple80)
                    .padding(top = 5.dp, bottom = 5.dp, start = 3.dp, end = 3.dp),
                color = Color.White,
            )

        }
    }
}