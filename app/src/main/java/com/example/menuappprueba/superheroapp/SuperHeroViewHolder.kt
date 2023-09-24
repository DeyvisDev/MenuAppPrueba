package com.example.menuappprueba.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit){
        binding.tvDuperheroName.text = superheroItemResponse.name


        Picasso.get().load(superheroItemResponse.SuperherImage.url).into(binding.ivSuperhero)

        binding.root.setOnClickListener{
            onItemSelected(superheroItemResponse.superheroId)
        }
    }
}