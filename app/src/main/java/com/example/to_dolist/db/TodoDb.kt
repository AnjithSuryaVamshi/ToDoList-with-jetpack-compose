package com.example.to_dolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDb : RoomDatabase() {
    abstract fun getTodoDao() : TodoDao

    companion object{
        @Volatile
        private var INSTANCE : TodoDb? = null

        fun getTodoDb(context: Context): TodoDb{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDb::class.java,
                    "todoDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}