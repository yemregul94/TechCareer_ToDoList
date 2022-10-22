package com.works.todolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.works.todolist.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getToDoDAO() : ToDoDAO
}