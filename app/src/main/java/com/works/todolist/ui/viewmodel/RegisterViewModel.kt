package com.works.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.works.todolist.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(var tdRepo: ToDoRepository)  : ViewModel() {
    fun register(toDo_detail:String){
        CoroutineScope(Dispatchers.Main).launch {
            tdRepo.register(toDo_detail)

        }
    }
}