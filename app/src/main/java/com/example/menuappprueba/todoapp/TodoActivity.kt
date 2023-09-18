package com.example.menuappprueba.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.R
import com.example.menuappprueba.Recycler.RecyclerActivity

class TodoActivity : AppCompatActivity() {

    private val categries = listOf(
        TaskCategory.Other,
        TaskCategory.Personal,
        TaskCategory.Business,
        TaskCategory.Pruebas
    )

    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
    }
    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
    }
    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categries)
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter
    }
}