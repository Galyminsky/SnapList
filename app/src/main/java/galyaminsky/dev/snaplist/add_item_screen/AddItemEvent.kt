package galyaminsky.dev.snaplist.add_item_screen

import galyaminsky.dev.snaplist.data.AddItem

sealed class AddItemEvent {
    data class OnDelete(val item: AddItem) : AddItemEvent()
    data class OnShowEditDialog(val item: AddItem) : AddItemEvent()
    data class OnTextChange(val text: String) : AddItemEvent()
    data class OnCheckedChange(val item: AddItem) : AddItemEvent()
    data object OnItemSave : AddItemEvent()
}