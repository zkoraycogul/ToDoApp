package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.data.entity.ToDoApp

@Dao
interface ToDoDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar() : List<ToDoApp>

    @Insert
    suspend fun toDoEkle(yapilacak:ToDoApp)

    @Update
    suspend fun toDoGuncelle(yapilacak:ToDoApp)

    @Delete
    suspend fun toDoSil(yapilacak:ToDoApp)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%' ")
    suspend fun toDoAra(aramaKelimesi:String) : List<ToDoApp>

}