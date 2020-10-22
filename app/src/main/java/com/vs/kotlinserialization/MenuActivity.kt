package com.vs.kotlinserialization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

class MenuActivity : AppCompatActivity(R.layout.activity_menu) {

    private val TAG = MenuActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fruitsListAsString = intent.getStringExtra(Constants.FRUITS_LIST)
        Log.d(TAG, "show_list_as_string $fruitsListAsString")

        val fruitsListAsObj = Json.encodeToJsonElement(fruitsListAsString)
        Log.d(TAG, "show_list_as_JSON $fruitsListAsString")

    }
}