package com.uxstate.instantscore.utils

sealed class UIEvent() {

    data class ShowSnackBarUiEvent(val message: String, val action: String) : UIEvent()
    data class DetailsScreenNavEvent(val fixtureId:Int):UIEvent()
}