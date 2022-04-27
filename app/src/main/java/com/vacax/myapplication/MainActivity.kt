package com.vacax.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "fuck")

    val gg= stringPreferencesKey("gaga")

    companion object {
        val fuckx = CoroutineScope(Dispatchers.IO)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.e("fuckyou","ggx!!")
//        fuckx.launch {
//            dataStore.edit {
//                Log.e("fuckyou","ggx!!")
//                it[gg]="234"
//            }
//        }
//        Log.e("fuckyou","ggx!!")

        fuckx.launch {
            Log.e("fuckyou","ggx!!")
            dataStore.edit {
                Log.e("fuckyou","ggx!!")
                val ggx=it[gg]
                Log.e("fuckyou",ggx!!)
            }
        }

    }
}


