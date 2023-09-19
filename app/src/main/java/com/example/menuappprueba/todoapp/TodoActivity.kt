package com.example.menuappprueba.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        val btnAddTask:Button = dialog.findViewById(R.id.btnAddTask)
        val etTask:EditText = dialog.findViewById(R.id.etTask)
        val rgCategories:RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton:RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory:TaskCategory = when(selectedRadioButton.text){
                    getString(R.string.rvBusiness) -> TaskCategory.Business
                    getString(R.string.rb_personal) -> TaskCategory.Personal
                    else -> TaskCategory.Other
                }
                tasks.add(Task(currentTask,currentCategory))
                updateTask()
                dialog.hide()
            }

        }
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

        tasksAdapter = TasksAdapter(tasks) {position -> onItemSelected(position)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }

    private fun updateTask(){

        tasksAdapter.notifyDataSetChanged()
    }
}