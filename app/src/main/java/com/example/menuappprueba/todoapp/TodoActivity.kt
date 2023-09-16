package com.example.menuappprueba.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.menuappprueba.R
import com.example.menuappprueba.Recycler.RecyclerActivity

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories:RecyclerView
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

    }
}