package com.works.todolist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.works.todolist.data.entity.ToDos
import com.works.todolist.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var tdRepo: ToDoRepository) : ViewModel() {
    var toDoList = MutableLiveData<List<ToDos>>()

    init {
        loadList()
    }

    fun loadList(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = tdRepo.loadList()
        }
    }

    fun delete(toDo_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            tdRepo.delete(toDo_id)
            loadList()
        }
    }

    fun search(query: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = tdRepo.search(query)
        }
    }
}