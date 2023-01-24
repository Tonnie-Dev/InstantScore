package com.uxstate.instantscore.utils

sealed class UIEvent() {

    data class ShowSnackBarUiEvent(val message: String, val action: String) : UIEvent()
}