package com.example.menuappprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.menuappprueba.IMCCalculator.ImcCalculatorActivity
import com.example.menuappprueba.Recycler.RecyclerActivity
import com.example.menuappprueba.settings.SettingsActivity
import com.example.menuappprueba.superheroapp.SuperHeroListActivity
import com.example.menuappprueba.todoapp.TodoActivity

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

        val btnGoReciclerView = findViewById<AppCompatButton>(R.id.btnGotReciclerView)
        btnGoReciclerView.setOnClickListener{
            navidateToReciclerView()
        }

        val btnTodoApp = findViewById<AppCompatButton>(R.id.btnTodoApp)
        btnTodoApp.setOnClickListener{
            navidatebtnTodoApp()
        }
        val btnSuperHeroApp = findViewById<AppCompatButton>(R.id.btnSuperHeroApp)
        btnSuperHeroApp.setOnClickListener{
            navidatebtnSuperHeroApp()
        }
        val btnSettings = findViewById<AppCompatButton>(R.id.btnSettings)
        btnSettings.setOnClickListener{
            navidatebtnSettings()
        }
    }

    private fun navidatebtnSettings() {
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navidatebtnSuperHeroApp() {
        val intent = Intent(this,SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navidatebtnTodoApp() {
        val intent = Intent(this,TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navidateToReciclerView() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludarApp(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateIMCApp(){
        val intent = Intent(this,RecyclerActivity::class.java)
        startActivity(intent)
    }
}