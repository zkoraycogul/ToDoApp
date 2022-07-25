package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDoApp
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.ui.fragment.ToDoAnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.ToDoAnasayfaFragmentViewModel
import com.example.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext:Context,
                  var yapilacaklarListesi:List<ToDoApp>,
                  var viewModel: ToDoAnasayfaFragmentViewModel)
    : RecyclerView.Adapter<ToDoAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil
            .inflate(layoutInflater,R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.toDoNesnesi = yapilacak

        t.satirCard.setOnClickListener {
            val gecis = ToDoAnasayfaFragmentDirections.toDoDetayGecis(yapilacak = yapilacak)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}