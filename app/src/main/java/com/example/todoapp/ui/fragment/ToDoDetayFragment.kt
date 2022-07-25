package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.ui.fragment.ToDoDetayFragmentArgs
import com.example.todoapp.ui.viewmodel.ToDoDetayFragmentViewModel
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoDetayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentTodoDetayBinding
    private lateinit var viewModel: ToDoDetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_detay, container, false)
        tasarim.toDoDetayFragment = this
        tasarim.toDoDetayToolbarBaslik = "Yapılacaklar Detay"

        val bundle:ToDoDetayFragmentArgs by navArgs()
        val gelenYap = bundle.yapilacak
        tasarim.toDoNesnesi = gelenYap

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ToDoDetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacak_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)
    }
}