package galyaminsky.dev.snaplist.utils

sealed class UiEvent {
    data object PopBackStack : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    data class ShowSnakeBar(val message: String) : UiEvent()
}