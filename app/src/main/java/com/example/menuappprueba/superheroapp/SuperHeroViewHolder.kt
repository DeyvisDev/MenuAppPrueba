package com.example.menuappprueba.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse){
        binding.tvDuperheroName.text = superheroItemResponse.name
    }
}