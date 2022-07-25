package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.repo.ToDoAppDaoRepository
import com.example.todoapp.room.ToDoDao
import com.example.todoapp.room.VeriTabani
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
    fun provideToDoDaoRepository(kdao:ToDoDao) : ToDoAppDaoRepository {
        return ToDoAppDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context:Context) : ToDoDao {
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"todoapp.sqlite")
            .createFromAsset("todoapp.sqlite").build()
        return vt.getToDoDao()
    }
}