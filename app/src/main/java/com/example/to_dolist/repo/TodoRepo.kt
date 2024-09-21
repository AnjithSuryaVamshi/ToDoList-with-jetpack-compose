package com.example.to_dolist.repo

import androidx.lifecycle.LiveData
import com.example.to_dolist.db.TodoDao
import com.example.to_dolist.db.TodoDb
import com.example.to_dolist.db.TodoEntity

class TodoRepo(private val todoDao : TodoDao) {

    suspend fun insertTodo(todoEntity: TodoEntity){
       todoDao.insertTodo(todoEntity)
    }
    suspend fun deleteTodo(todoEntity: TodoEntity){
        todoDao.deleteTodo(todoEntity)
    }
    fun getAllTodo() : LiveData<List<TodoEntity>>{
        return   todoDao.getAllTodo()
    }
}