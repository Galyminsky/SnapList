package galyaminsky.dev.snaplist.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import galyaminsky.dev.snaplist.data.ShoppingListItem
import galyaminsky.dev.snaplist.data.ShoppingListRepository
import galyaminsky.dev.snaplist.dialog.DialogController
import galyaminsky.dev.snaplist.dialog.DialogEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel(), DialogController {


    override var dialogTitle = mutableStateOf("List Name: ")
        private set
    override var editTableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditTableText = mutableStateOf(true)
        private set


    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnItemSave -> {
                if (editTableText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListItem(
                            null,
                            editTableText.value,
                            "12/12/2024 15:57",
                            0,
                            0,
                        )
                    )
                }
            }

            is MainScreenEvent.OnShowEditDialog -> {
                openDialog.value = true
            }
        }
    }


    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnTextChange -> {
                editTableText.value = event.text
            }

            is DialogEvent.OnCancel -> {
                openDialog.value = false
            }

            is DialogEvent.OnConfirm -> {
                onEvent(MainScreenEvent.OnItemSave)
                openDialog.value = false
            }
        }
    }
}