package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoAnasayfaBinding
import com.example.todoapp.ui.adapter.ToDoAdapter
import com.example.todoapp.ui.viewmodel.ToDoAnasayfaFragmentViewModel
import com.example.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoAnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentTodoAnasayfaBinding
    private lateinit var viewModel: ToDoAnasayfaFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        tasarim = DataBindingUtil.inflate(inflater,
            R.layout.fragment_todo_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val adapter = ToDoAdapter(requireContext(),it,viewModel)
            tasarim.toDoAdapter = adapter
        }

        return tasarim.root
    }

    fun fabTikla(view:View){
        Navigation.gecisYap(view,R.id.toDoKayitGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:ToDoAnasayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }
}