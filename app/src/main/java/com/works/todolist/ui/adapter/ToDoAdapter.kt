package com.works.todolist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.works.todolist.R
import com.works.todolist.data.entity.ToDos
import com.works.todolist.databinding.CardDesignBinding
import com.works.todolist.ui.fragment.HomeFragmentDirections
import com.works.todolist.ui.viewmodel.HomeViewModel

class ToDoAdapter(var mContext: Context,
                  var toDoList: List<ToDos>,
                  var viewModel: HomeViewModel) : RecyclerView.Adapter<ToDoAdapter.Holder>() {

        inner class Holder(binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root){
            var binding: CardDesignBinding
            init {
                this.binding = binding
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val toDoItem = toDoList.get(position)
        val bind = holder.binding
        bind.toDoObject = toDoItem

        bind.rowCard.setOnClickListener {
            val nav = HomeFragmentDirections.homeToDetails(toDoItem)
            Navigation.findNavController(it).navigate(nav)
        }

        bind.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "${toDoItem.toDo_detail} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.delete(toDoItem.toDo_id)
                    Snackbar.make(it, "${toDoItem.toDo_detail} silindi", Snackbar.LENGTH_LONG).show()
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }


}