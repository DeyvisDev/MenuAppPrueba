package com.example.menuappprueba.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menuappprueba.R
import com.example.menuappprueba.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}