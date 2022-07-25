package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoAppDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoKayitFragmentViewModel @Inject constructor (var krepo:ToDoAppDaoRepository) : ViewModel() {
    fun kayit(yapilacak_is:String){
       krepo.toDoKayit(yapilacak_is)
    }
}