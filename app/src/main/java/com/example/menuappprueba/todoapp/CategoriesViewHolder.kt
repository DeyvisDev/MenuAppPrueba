package com.example.menuappprueba.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.R

class CategoriesViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider:TextView = view.findViewById(R.id.vDivider)

    fun render(taskCategory: TaskCategory){

    }

}