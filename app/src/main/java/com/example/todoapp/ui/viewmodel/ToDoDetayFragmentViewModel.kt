package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoAppDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoDetayFragmentViewModel @Inject constructor (var krepo:ToDoAppDaoRepository) : ViewModel() {
    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        krepo.toDoGuncelle(yapilacak_id,yapilacak_is)
    }
}