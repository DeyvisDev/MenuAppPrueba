package com.example.menuappprueba.superheroapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.isVisible
import com.example.menuappprueba.R
import com.example.menuappprueba.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperHeroActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding:ActivityDetailSuperHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id:String = intent.getStringExtra(EXTRA_ID).orEmpty()
        
        getSuperHeroInformation(id)
    }

    private fun getSuperHeroInformation(id: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)
            if (superheroDetail.body()!=null){
                runOnUiThread { createUI(superheroDetail.body()!!) }
                superheroDetail.body()
            }
        }
    }

    private fun createUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.imSuperHero)
        binding.tvSuperHeroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperHeroRealName.text = superhero.biography.fullName
        binding.tvSuperHeroPublisher.text = superhero.biography.publisher

    }

    private fun prepareStats(powerstats: powerStatsResponse) {
        updateHeight(binding.viewwwCombat,powerstats.combat)
        updateHeight(binding.viewDurability,powerstats.durability)
        updateHeight(binding.viewSpeed,powerstats.speed)
        updateHeight(binding.viewIntelligence,powerstats.intelligence)
        updateHeight(binding.viewPower,powerstats.power)
        updateHeight(binding.viewStrength,powerstats.strength)
    }
    private fun updateHeight(view:View,stat:String){
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        view.layoutParams = params
    }
    private fun pixelToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}