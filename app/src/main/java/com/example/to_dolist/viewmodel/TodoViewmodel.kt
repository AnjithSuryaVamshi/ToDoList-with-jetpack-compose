package com.example.to_dolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.to_dolist.db.TodoDb
import com.example.to_dolist.db.TodoEntity
import com.example.to_dolist.repo.TodoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewmodel(application: Application) : AndroidViewModel(application)  {

    private val todoRepo  : TodoRepo
    val allTodos : LiveData<List<TodoEntity>>
    init {
        val todoDao = TodoDb.getTodoDb(application).getTodoDao()
        todoRepo = TodoRepo(todoDao)
        allTodos = todoRepo.getAllTodo()
    }
    fun insert(todo : TodoEntity) =  viewModelScope.launch (Dispatchers.IO){
        todoRepo.insertTodo(todo)
    }
    fun delete(todo : TodoEntity) =  viewModelScope.launch(Dispatchers.IO) {
        todoRepo.deleteTodo(todo)
    }
    fun update(todo: TodoEntity) = viewModelScope.launch(Dispatchers.IO) {
        todoRepo.updateTodo(todo)
    }
}