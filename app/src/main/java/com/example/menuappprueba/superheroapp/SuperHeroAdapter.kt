package com.example.menuappprueba.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.R

class SuperHeroAdapter (var superheroList:List<SuperheroItemResponse> = emptyList()):
    RecyclerView.Adapter<SuperHeroViewHolder>(){
    fun updateList(superheroList:List<SuperheroItemResponse>){
        this.superheroList = superheroList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun getItemCount()=superheroList.size
}