package com.example.menuappprueba.settings


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
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
    private var firstTime:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter{firstTime}.collect{ settingModel ->
                if (settingModel!=null){
                    runOnUiThread {
                        binding.switchVibration.isChecked = settingModel.vibration
                        binding.switchBluetooth.isChecked = settingModel.blooetoth
                        binding.switchDarkMode.isChecked = settingModel.darkMode
                        binding.rsVolume.setValues(settingModel.volume.toFloat())
                        firstTime = !firstTime
                    }
                }
            }
        }

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
            //

            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLOOETOTH,value)
            }
        }
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->
            if (value){
                enableDarkmode()
            } else {
                disableDarkmode()
            }
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
    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences->
            SettingsModel(
                volume = preferences[intPreferencesKey(VOLUME_LVL)]?:50,
                blooetoth = preferences[booleanPreferencesKey(KEY_BLOOETOTH)]?:true,
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)]?:false,
                darkMode = preferences[booleanPreferencesKey(KEY_DARKMODE)]?:true
            )
        }
    }
    private fun enableDarkmode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }
    private fun disableDarkmode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

    }
    private fun onBlooetoth(){

    }
    private fun offBlooetoth(){
        //:)

    }
}