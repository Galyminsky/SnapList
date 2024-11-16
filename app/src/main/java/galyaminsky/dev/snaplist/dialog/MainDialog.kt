package galyaminsky.dev.snaplist.dialog


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import galyaminsky.dev.snaplist.ui.theme.DarkText
import galyaminsky.dev.snaplist.ui.theme.LightWhite


@Composable
fun MainDialog(dialogController: DialogController) {
    if (dialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onDialogEvent(DialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = DarkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (dialogController.showEditTableText.value) TextField(
                        value = dialogController.editTableText.value,
                        onValueChange = { text ->
                            dialogController.onDialogEvent(DialogEvent.OnTextChange(text))
                        },
                        label = {
                            Text(text = "List Name")
                        },
                        modifier = Modifier,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = LightWhite,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp),
                        singleLine = true
                    )

                }
            },
            confirmButton = {
                TextButton(onClick = { dialogController.onDialogEvent(DialogEvent.OnConfirm) }) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { dialogController.onDialogEvent(DialogEvent.OnCancel) }) {
                    Text(text = "CANCEL")
                }
            }
        )
    }
}


