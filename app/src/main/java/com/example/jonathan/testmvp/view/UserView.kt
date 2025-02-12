package com.example.jonathan.testmvp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.example.jonathan.testmvp.model.User

@Composable
fun UserView(user: User, onNameChange: (String) -> Unit) {
    Column {
        TextField(
            value = user.name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )

        Text("Age: ${user.age}")
    }
}
