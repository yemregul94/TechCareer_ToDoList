package com.works.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.works.todolist.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(var tdRepo: ToDoRepository) : ViewModel() {
    fun update(toDo_id:Int, toDo_detail:String){
        CoroutineScope(Dispatchers.Main).launch {
            tdRepo.update(toDo_id, toDo_detail)
        }
    }
}