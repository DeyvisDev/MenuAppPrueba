package com.example.menuappprueba.IMCCalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextClock
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.menuappprueba.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 70
    private var currentAge:Int = 25

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubstractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight:TextView

    private lateinit var btnSubstractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()

    }
    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
    }
    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
        btnPlusWeight.setOnClickListener{
            currentWeight +=1
            setWeight()
        }
        btnSubstractWeight.setOnClickListener{
            currentWeight -=1
            setWeight()
        }
        btnPlusAge.setOnClickListener{
            currentAge +=1
            setAge()
        }
        btnSubstractAge.setOnClickListener{
            currentAge -=1
            setAge()
        }
    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
    }
    private fun setWeight(){
        tvWeight.text=currentWeight.toString()
    }
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }
    private fun getBackgroundColor(isSelectedComponent:Boolean):Int{

        val coloReference = if(isSelectedComponent){
            R.color.background_component_selected
        }else  {
            R.color.background_component
        }
        return ContextCompat.getColor(this,coloReference)
    }
    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}