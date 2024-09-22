package com.example.to_dolist.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface TodoDao {

    @Insert
    suspend fun insertTodo(todoEntity: TodoEntity)

    @Delete
    suspend fun deleteTodo(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo_table")
    fun getAllTodo(): LiveData<List<TodoEntity>>

    @Update
    suspend fun updateTodo(todoEntity: TodoEntity)
}
