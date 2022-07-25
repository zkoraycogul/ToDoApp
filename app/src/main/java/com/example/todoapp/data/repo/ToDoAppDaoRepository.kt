package com.example.todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.data.entity.ToDoApp
import com.example.todoapp.room.ToDoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoAppDaoRepository (var kdao:ToDoDao){
    var yapilacaklarListesi:MutableLiveData<List<ToDoApp>>

    init {
        yapilacaklarListesi = MutableLiveData()
    }

    fun yapilacaklariGetir() : MutableLiveData<List<ToDoApp>> {
        return  yapilacaklarListesi
    }

    fun toDoKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val ekleToDo = ToDoApp(0,yapilacak_is)
            kdao.toDoEkle(ekleToDo)
        }
    }

    fun toDoGuncelle(yapilacak_id:Int,yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenToDo = ToDoApp(yapilacak_id,yapilacak_is)
            kdao.toDoGuncelle(guncellenenToDo)
        }
    }

    fun toDoAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = kdao.toDoAra(aramaKelimesi)
        }
    }

    fun toDoSil(yapilacak_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenToDo = ToDoApp(yapilacak_id,"")
            kdao.toDoSil(silinenToDo)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
       val job = CoroutineScope(Dispatchers.Main).launch {
           yapilacaklarListesi.value = kdao.tumYapilacaklar()
       }
    }
}