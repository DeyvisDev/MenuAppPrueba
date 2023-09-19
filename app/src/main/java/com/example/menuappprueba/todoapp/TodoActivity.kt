package com.example.menuappprueba.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.R
import com.example.menuappprueba.Recycler.RecyclerActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categries = listOf(
        TaskCategory.Other,
        TaskCategory.Personal,
        TaskCategory.Business,
        TaskCategory.Pruebas
    )
    private val tasks = mutableListOf(
        Task("PruebaBusiness", TaskCategory.Business),
        Task("PruebaPersonal", TaskCategory.Personal),
        Task("PruebaOther", TaskCategory.Other),
        Task("PruebaPruebas", TaskCategory.Pruebas)
    )

    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks:RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fabAddTask:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener{
            showDialog()
        }
    }
    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }
    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categries)
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }
}