package com.example.menuappprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.menuappprueba.IMCCalculator.ImcCalculatorActivity

class MenuActivityV2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_v2)

        val btnSaludar = findViewById<AppCompatButton>(R.id.btnSaludarApp)
        btnSaludar.setOnClickListener{
            navigateToSaludarApp()
        }

        val btnIMC = findViewById<AppCompatButton>(R.id.btnIMCApp)
        btnIMC.setOnClickListener{
            navigateIMCApp()
        }
    }
    private fun navigateToSaludarApp(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateIMCApp(){
        val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
}