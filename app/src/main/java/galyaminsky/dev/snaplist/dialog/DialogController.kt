package galyaminsky.dev.snaplist.dialog

import androidx.compose.runtime.MutableState

interface DialogController {
    val dialogTitle: MutableState<String>
    val editTableText: MutableState<String>
    val openDialog: MutableState<Boolean>
    val showEditTableText: MutableState<Boolean>

    fun onDialogEvent(event: DialogEvent)
}