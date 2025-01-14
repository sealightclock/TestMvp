package com.example.jonathan.testmvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.jonathan.testmvp.presenter.UserPresenter
import com.example.jonathan.testmvp.view.UserView

class MainActivity : ComponentActivity() {
    private val presenter = UserPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val user by presenter.userState.collectAsState()

            UserView(
                user = user,
                onNameChange = { presenter.updateUserName(it) }
            )
        }
    }
}
