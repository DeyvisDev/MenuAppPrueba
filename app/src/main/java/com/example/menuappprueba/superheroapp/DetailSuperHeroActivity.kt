package com.example.menuappprueba.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menuappprueba.R

class DetailSuperHeroActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_super_hero)
        //intent.extras.getString(EXTRA_ID)
    }
}