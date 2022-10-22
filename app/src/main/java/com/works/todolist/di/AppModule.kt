package com.works.todolist.di

import android.content.Context
import androidx.room.Room
import com.works.todolist.data.datasource.ToDoDataSource
import com.works.todolist.data.repo.ToDoRepository
import com.works.todolist.room.Database
import com.works.todolist.room.ToDoDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoRepository(tdDS:ToDoDataSource) : ToDoRepository {
        return ToDoRepository(tdDS)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(tdDAO: ToDoDAO) : ToDoDataSource {
        return ToDoDataSource(tdDAO)
    }

    @Provides
    @Singleton
    fun provideToDoDAO(@ApplicationContext context: Context): ToDoDAO {
        val db = Room.databaseBuilder(context, Database::class.java, "toDoList.db").createFromAsset("toDoList.db").build()
        return db.getToDoDAO()
    }

}