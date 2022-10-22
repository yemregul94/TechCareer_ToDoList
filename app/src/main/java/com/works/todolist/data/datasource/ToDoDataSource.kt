package com.works.todolist.data.datasource

import com.works.todolist.data.entity.ToDos
import com.works.todolist.room.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdDAO: ToDoDAO) {

    suspend fun loadList(): List<ToDos> =
        withContext(Dispatchers.IO) {
        tdDAO.loadList()
    }

    suspend fun register(toDo_detail: String){
        val newToDo = ToDos(0, toDo_detail)
        tdDAO.register(newToDo)
    }

    suspend fun update(toDo_id:Int, toDo_detail: String){
        val updatedToDo = ToDos(toDo_id, toDo_detail)
        tdDAO.update(updatedToDo)
    }

    suspend fun delete(toDo_id: Int){
        val deletedToDo = ToDos(toDo_id, "")
        tdDAO.delete(deletedToDo)
    }

    suspend fun search(query: String) : List<ToDos> =
        withContext(Dispatchers.IO){
            tdDAO.search(query)
        }
}