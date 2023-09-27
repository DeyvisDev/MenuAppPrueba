package com.example.menuappprueba.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.menuappprueba.R
import com.example.menuappprueba.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="settings")

class SettingsActivity : AppCompatActivity() {
    companion object{
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_BLOOETOTH = "key_blooetoth"
        const val KEY_DARKMODE = "key_darkmode"
        const val KEY_VIBRATION = "key_vibration"
    }
    private lateinit var binding:ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            Log.i("DeyvisDev","El valor es $value")
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }

        }
        binding.switchBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLOOETOTH,value)
            }
        }
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARKMODE,value)
            }
        }
        binding.switchVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATION,value)
            }
        }
    }

    private suspend fun saveVolume(value:Int){
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(VOLUME_LVL)] = value
        }
    }
    private suspend fun saveOptions(key:String, value:Boolean){
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value

        }

    }
}