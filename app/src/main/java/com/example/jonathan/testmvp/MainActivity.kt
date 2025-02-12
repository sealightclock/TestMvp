package com.example.jonathan.testmvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.jonathan.testmvp.presenter.UserPresenter
import com.example.jonathan.testmvp.view.UserScreen

class MainActivity : ComponentActivity() {
    private val presenter = UserPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val user by presenter.userState.collectAsState()

            /**
             * The "presenter" is the bridge between the view ("UserScreen") and the model ("user").
             * It should not be used directly in the view.
             * So we pass "user" (the model) to the view and "onNameChange" (the presenter).
             * Passing user makes the view dumb, stateless, reusable, and easy to test.
             * Let MainActivity to drive the Presenter.
             *
             * In MVP, the Presenter should handle all the logic and pass the current UI state (user)
             * to the View. The View only renders and triggers callbacks (onNameChange), which are
             * then handled by the Presenter.
             */
            UserScreen(
                user = user,
                onNameChange = { presenter.updateUserName(it) },
                onAgeChange = { presenter.updateUserAge(it) }
            )
        }
    }
}
