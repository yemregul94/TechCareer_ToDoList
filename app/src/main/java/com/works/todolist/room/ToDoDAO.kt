package com.works.todolist.room

import androidx.room.*
import com.works.todolist.data.entity.ToDos

@Dao
interface ToDoDAO {
    @Query("SELECT * FROM toDos")
    suspend fun loadList(): List<ToDos>

    @Insert
    suspend fun register(toDo: ToDos)

    @Update
    suspend fun update(toDo: ToDos)

    @Delete
    suspend fun delete(toDo: ToDos)

    @Query("SELECT * FROM toDos WHERE toDo_detail like '%' || :query || '%'")
    suspend fun search(query: String): List<ToDos>
}