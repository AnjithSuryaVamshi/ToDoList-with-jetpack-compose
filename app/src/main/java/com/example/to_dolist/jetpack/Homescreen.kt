package com.example.to_dolist.jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.to_dolist.viewmodel.TodoViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(todoViewmodel: TodoViewmodel = viewModel()) {

    var openDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { openDialog = true }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add new to-do"
                )
            }
        },
        topBar = {
            TopAppBar(
                title = { Text(text = "To-Do List App") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TodoListScreen(todoViewmodel)
        }


        if (openDialog) {
            FullScreenDialog(
                openDialog = openDialog,
                todoViewmodel = todoViewmodel,
                onDismiss = { openDialog = false }
            )
        }
    }
}
