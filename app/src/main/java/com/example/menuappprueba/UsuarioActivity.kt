package com.example.menuappprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        val tvNameUsuario = findViewById<TextView>(R.id.tvName)
        val name:String = intent.extras?.getString("name").orEmpty()
        tvNameUsuario.text = "Hola "+name

    }
}