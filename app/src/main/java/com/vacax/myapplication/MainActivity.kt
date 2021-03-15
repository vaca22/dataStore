package com.vacax.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    companion object{
        val dataScope = CoroutineScope(Dispatchers.IO)

    }

    private val EXAMPLE_COUNTER = intPreferencesKey("example_counter")


    suspend fun incrementCounter() {
       applicationContext.dataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val exampleCounterFlow: Flow<Int> = applicationContext.dataStore.data
                .map { preferences ->
                    // No type safety.
                    preferences[EXAMPLE_COUNTER] ?: 0
                }

        dataScope.launch {
//            exampleCounterFlow.collect { value ->
//                run {
//                    Log.e("dfdf", "sdklfjkl圣诞快乐房价考虑 $value")
//                }
//            }

            exampleCounterFlow.collect { value -> kotlin.run {
                Log.e("dfdf", "sdklfjkl圣诞快乐房价考虑 $value")
            }  }

//            applicationContext.dataStore.edit { settings ->
//
//                settings[EXAMPLE_COUNTER] = 1000
//            }

        }


    }
}


