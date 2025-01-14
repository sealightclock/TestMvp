package com.example.jonathan.testmvp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.jonathan.testmvp.model.User

@Composable
fun UserView(user: User, onNameChange: (String) -> Unit) {
    Column {
        TextField(
            value = user.name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
        Text("Email: ${user.email}")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserView() {
    val user = remember { User(name = "John Doe", email = "john.doe@example.com") }
    UserView(user) {}
}
