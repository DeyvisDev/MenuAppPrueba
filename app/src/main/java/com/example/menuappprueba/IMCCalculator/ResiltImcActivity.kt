package com.example.menuappprueba.IMCCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.menuappprueba.IMCCalculator.ImcCalculatorActivity.Companion.IMC_KEY
import com.example.menuappprueba.R

class ResiltImcActivity : AppCompatActivity() {
    private lateinit var tvResoult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resilt_imc)

        val imc:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponent()
        initUI(imc)
    }

    private fun initUI(imc: Double) {
        tvIMC.text = imc.toString()
        when(imc){
            in 0.00 .. 18.50 -> {//bajo peso
                tvResoult
                tvDescription

            }
            in 18.51 .. 24.99 -> {//peso normal
                tvResoult
                tvDescription
            }
            in 25.00 .. 29.99 -> {//sobre peso
                tvResoult
                tvDescription
            }
            in 30.00 .. 99.00 -> {//obesidad
                tvResoult
                tvDescription
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

    }
}