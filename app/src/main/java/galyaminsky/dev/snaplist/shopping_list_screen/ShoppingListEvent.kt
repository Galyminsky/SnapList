package galyaminsky.dev.snaplist.shopping_list_screen

import galyaminsky.dev.snaplist.data.ShoppingListItem

sealed class ShoppingListEvent {
    data class OnShowDeleteDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnShowEditDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnItemClick(val item: ShoppingListItem) : ShoppingListEvent()
    object OnItemSave : ShoppingListEvent()
}