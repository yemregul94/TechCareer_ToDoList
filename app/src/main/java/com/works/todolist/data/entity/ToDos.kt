package com.works.todolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class ToDos (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "toDo_id") @NotNull var toDo_id: Int,
                  @ColumnInfo(name = "toDo_detail") @NotNull var toDo_detail: String) : Serializable