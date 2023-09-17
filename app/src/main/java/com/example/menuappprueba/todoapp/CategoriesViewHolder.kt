package com.example.menuappprueba.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.R

class CategoriesViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider:View = view.findViewById(R.id.vDivider)

    fun render(taskCategory: TaskCategory){
        tvCategoryName.text = "Ejemplo"
        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = "Negoco"
            }
            TaskCategory.Other -> TODO()
            TaskCategory.Personal -> TODO()
        }
    }

}