package com.example.menuappprueba.IMCCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.menuappprueba.IMCCalculator.ImcCalculatorActivity.Companion.IMC_KEY
import com.example.menuappprueba.R

class ResiltImcActivity : AppCompatActivity() {
    private lateinit var tvResoult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resilt_imc)

        val imc:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponent()
        initUI(imc)
        iniListener()
    }

    private fun iniListener() {
        btnRecalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(imc: Double) {
        tvIMC.text = imc.toString()
        when(imc){
            in 0.00 .. 18.50 -> {//bajo peso
                tvResoult.text = getString(R.string.title_bajo_peso)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)

            }
            in 18.51 .. 24.99 -> {//peso normal
                tvResoult.text = getString(R.string.title_normal)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.normal))
                tvDescription.text = getString(R.string.description_normal)
            }
            in 25.00 .. 29.99 -> {//sobre peso
                tvResoult.text = getString(R.string.title_sobre_peso)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.sobre_peso))
                tvDescription.text = getString(R.string.description_sobre_peso)
            }
            in 30.00 .. 99.00 -> {//obesidad
                tvResoult.text = getString(R.string.title_obecidad)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.obecidad))
                tvDescription.text = getString(R.string.description_obecidad)
            }
            else ->{//error
                tvIMC.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
                tvResoult.text = getString(R.string.error)
            }
        }
    }

    private fun initComponent() {
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        tvResoult = findViewById(R.id.tvResoult)
        btnRecalculate = findViewById(R.id.btnRecalculate)

    }
}