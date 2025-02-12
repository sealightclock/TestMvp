package com.example.jonathan.testmvp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.example.jonathan.testmvp.model.User

@Composable
fun UserScreen(
    user: User,
    onNameChange: (String) -> Unit,
    onAgeChange: (Int) -> Unit
) {
    Column {
        TextField(
            value = user.name,
            onValueChange = onNameChange,
            label = {
                Text("Name")
            }
        )

        TextField(
            value = user.age.toString(),
            onValueChange = { newAge ->
                val parsedAge = newAge.toIntOrNull() // Convert user input to Int
                if (parsedAge != null) {
                    onAgeChange(parsedAge)
                }
            },
            label = {
                Text("Age")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // Restrict keyboard to numbers
        )
    }
}
