package com.example.menuappprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnName = findViewById<Button>(R.id.btnName)
        val etName = findViewById<EditText>(R.id.etName)
        btnName.setOnClickListener{
            var name = etName.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this,UsuarioActivity::class.java)
                intent.putExtra("name",name)
                startActivity(intent)
            }
        }
    }
}