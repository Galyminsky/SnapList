package galyaminsky.dev.snaplist.shopping_list_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import galyaminsky.dev.snaplist.data.ShoppingListItem
import galyaminsky.dev.snaplist.data.ShoppingListRepository
import galyaminsky.dev.snaplist.utils.DialogController
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel(), DialogController {

    private var listItem: ShoppingListItem? = null

    override var dialogTitle = mutableStateOf("")
        private set
    override var editTableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditTableText = mutableStateOf(false)
        private set

    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListItem(
                            listItem?.id,
                            editTableText.value,
                            "12/12/2024 15:57",
                            listItem?.allItemCount ?: 0,
                            listItem?.allSelectedItemCount ?: 0,
                        )
                    )
                }
            }

            is ShoppingListEvent.OnItemClick -> {

            }

            is ShoppingListEvent.OnShowEditDialog -> {
                listItem = event.item
            }

            is ShoppingListEvent.OnShowDeleteDialog -> {

            }
        }
    }
}