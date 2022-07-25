package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoKayitBinding
import com.example.todoapp.ui.viewmodel.ToDoKayitFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
@AndroidEntryPoint
class ToDoKayitFragment : Fragment() {
    private lateinit var tasarim:FragmentTodoKayitBinding
    private lateinit var viewModel: ToDoKayitFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_kayit, container, false)
        tasarim.toDoKayitFragment = this
        tasarim.toDoKayitToolbarBaslik = "Yapılacaklar Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ToDoKayitFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(yapilacak_is:String){
        viewModel.kayit(yapilacak_is)
    }
}