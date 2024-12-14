package galyaminsky.dev.snaplist.add_item_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import galyaminsky.dev.snaplist.data.AddItem
import galyaminsky.dev.snaplist.data.AddItemRepository
import galyaminsky.dev.snaplist.dialog.DialogController
import galyaminsky.dev.snaplist.dialog.DialogEvent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    private val repository: AddItemRepository, savedStateHandle: SavedStateHandle
) : ViewModel(), DialogController {

    var itemList: Flow<List<AddItem>>? = null

    init {
        val listId = savedStateHandle.get<String>("listId")?.toInt()
        itemList = listId?.let { repository.getAllItemsById(it) }
        Log.d("MyLog", "listId ViewModel: $listId")
    }


    override var dialogTitle = mutableStateOf("")
        private set
    override var editTableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditTableText = mutableStateOf(true)
        private set


    fun onEvent(event: AddItemEvent) {

    }


    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnTextChange -> {
                editTableText.value = event.text
            }

            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editTableText.value = ""
            }

            is DialogEvent.OnConfirm -> {
                openDialog.value = false
                editTableText.value = ""
            }
        }
    }
}