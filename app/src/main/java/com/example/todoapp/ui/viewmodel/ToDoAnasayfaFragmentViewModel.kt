package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDoApp
import com.example.todoapp.data.repo.ToDoAppDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoAnasayfaFragmentViewModel @Inject constructor (var krepo:ToDoAppDaoRepository) : ViewModel() {

    var yapilacaklarListesi = MutableLiveData<List<ToDoApp>>()

    init {
        yapilacaklariYukle()
        yapilacaklarListesi = krepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        krepo.toDoAra(aramaKelimesi)
    }

    fun sil(yapilacak_id:Int){
        krepo.toDoSil(yapilacak_id)
    }

    fun yapilacaklariYukle(){
        krepo.tumYapilacaklariAl()
    }
}