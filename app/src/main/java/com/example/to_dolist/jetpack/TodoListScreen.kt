package com.example.to_dolist.jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_dolist.db.TodoEntity
import com.example.to_dolist.ui.theme.Pink80
import com.example.to_dolist.viewmodel.TodoViewmodel

@Composable
fun TodoListScreen(todoViewmodel: TodoViewmodel) {
    val allTodos by todoViewmodel.allTodos.observeAsState(initial = emptyList())
    if (allTodos.isEmpty()) {
        // Display "Nothing to do" message if the list is empty
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center,

        ) {
            Box(
                modifier = Modifier
                    .background(Pink80, RoundedCornerShape(10.dp))
                    .width(160.dp)
                    .height(90.dp)
                    .alpha(.3f),

                contentAlignment = Alignment.Center,


                ) {
                Text(
                    text = "Nothing to do",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(allTodos) { todo ->
                TodoItemCard(
                    todo = todo,
                    onDelete = { todoViewmodel.delete(it) },
                    onComplete = { completedTodo ->
                        todoViewmodel.update(completedTodo.copy(isComplete = !completedTodo.isComplete))
                    })
            }
        }
    }
}

@Composable
fun TodoItemCard(
    todo: TodoEntity,
    onDelete: (TodoEntity) -> Unit,
    onComplete: (TodoEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Checkbox for marking task as complete
            Checkbox(
                checked = todo.isComplete,
                onCheckedChange = { onComplete(todo) }
            )

            // Task text with strikethrough if completed
            Text(
                text = todo.work,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                textDecoration = if (todo.isComplete) TextDecoration.LineThrough else null
            )

            // Delete icon to remove task
            IconButton(onClick = { onDelete(todo) }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete To-Do", tint = Color.Red)
            }
        }
    }
}
