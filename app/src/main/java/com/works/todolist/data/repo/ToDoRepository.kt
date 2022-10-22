package com.works.todolist.data.repo

import com.works.todolist.data.datasource.ToDoDataSource
import com.works.todolist.data.entity.ToDos

class ToDoRepository(var tdDS: ToDoDataSource) {

    suspend fun loadList(): List<ToDos> = tdDS.loadList()

    suspend fun register(toDo_detail:String) = tdDS.register(toDo_detail)

    suspend fun update(toDo_id:Int, toDo_detail: String) = tdDS.update(toDo_id, toDo_detail)

    suspend fun delete(toDo_id:Int) = tdDS.delete(toDo_id)

    suspend fun search(query: String) = tdDS.search(query)
}