package com.example.to_dolist.jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.to_dolist.db.TodoEntity
import com.example.to_dolist.viewmodel.TodoViewmodel
import java.util.UUID

@Composable
fun FullScreenDialog(
    openDialog: Boolean,
    todoViewmodel: TodoViewmodel,
    onDismiss: () -> Unit
) {
    if (openDialog) {
        var taskText by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Add New To-Do") },
            text = {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    TextField(
                        value = taskText,
                        onValueChange = { taskText = it },
                        label = { Text("Task") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(onClick = {

                    if (taskText.isNotEmpty()) {
                        todoViewmodel.insert(
                            TodoEntity(
                                id = 0,
                                work = taskText,
                                isComplete = false
                            )
                        )
                        onDismiss() // Close the dialog after adding
                    }
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Cancel")
                }
            },
            shape = RoundedCornerShape(16.dp),
            properties = DialogProperties(dismissOnClickOutside = false)
        )
    }

}
