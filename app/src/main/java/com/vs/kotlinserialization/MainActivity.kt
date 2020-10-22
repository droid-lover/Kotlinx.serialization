package com.vs.kotlinserialization

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val TAG = MainActivity::class.java.simpleName
    val fruits = arrayListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnAddItemToMenu.setOnClickListener { addItemToMenu() }
        btnShowMenu.setOnClickListener { showMenu() }
    }

    private fun addItemToMenu() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val et = EditText(this)
        et.apply {
            hint = "enter fruit name"
            maxLines = 1
        }
        val layout = FrameLayout(this)
        layout.setPaddingRelative(45, 15, 45, 15)
        layout.addView(et)
        builder.apply {
            setView(layout)
            setMessage("Add a Fruit to menu")
            setCancelable(true)
            setPositiveButton("Add") { dialog, _ ->
                val fruit = Fruit(et.text.toString().trim())
                fruits.add(fruit)
                Log.d(TAG, "inside_show_menu ${Json.encodeToString(fruit)}")
                dialog.cancel()
            }
            setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        }.create()
        builder.show()
    }


    private fun showMenu() {
        Log.d(TAG, "inside_show_menu ${Json.encodeToJsonElement(fruits)}")
        startActivity(Intent(this,MenuActivity::class.java).putExtra(
                Constants.FRUITS_LIST,Json.encodeToString(fruits)
        ))
    }


}