package galyaminsky.dev.snaplist.main_screen

sealed class MainScreenEvent {
    data object OnShowEditDialog : MainScreenEvent()
    data object OnItemSave : MainScreenEvent()
}