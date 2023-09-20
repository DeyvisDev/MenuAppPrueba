package com.example.menuappprueba.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.example.menuappprueba.R
import com.example.menuappprueba.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.seachView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false

            }

            override fun onQueryTextChange(newText: String?) = false


        })
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch { 
            val myResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful){
                val response:SuperHeroDataResponse? = myResponse.body()
                if (response!=null){
                    Log.i("deyvisdev",response.toString())
                    runOnUiThread { binding.progressBar.isVisible = false }
                }
                Log.i("deyvisdev","Funcionnaaaa ;)")
            }else{
                Log.i("deyvisdev","No Funcionnaaaa ;(")
            }
        }

    }
    private fun getRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}