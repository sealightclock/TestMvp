package com.example.jonathan.testmvp.presenter

import com.example.jonathan.testmvp.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserPresenter {
    private val _userState = MutableStateFlow(
        User(
        "Jane Doe",
        26
        )
    )
    val userState: StateFlow<User> = _userState

    fun updateUserName(newName: String) {
        _userState.value = _userState.value.copy(name = newName)
    }

    fun updateUserAge(newAge: Int) {
        _userState.value = _userState.value.copy(age = newAge)
    }
}
