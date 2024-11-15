package galyaminsky.dev.snaplist.shopping_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import galyaminsky.dev.snaplist.data.ShoppingListItem
import galyaminsky.dev.snaplist.data.ShoppingListRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel() {

    private var listItem: ShoppingListItem? = null
    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListItem(
                            listItem?.id,
                            "List 1",
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