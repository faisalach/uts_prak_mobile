package com.faisal.pizzarestaurant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PackageManagerCompat.LOG_TAG


class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        // access the items of the list
        val storeArr = arrayOf("Cihampelas","Cibiru")

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.selectboxStore)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, storeArr)
            spinner.adapter = adapter
        }

        val selectboxStore  = findViewById<Spinner>(R.id.selectboxStore)
        val inputName       = findViewById<EditText>(R.id.inputName)
        val btnKirim        = findViewById<Button>(R.id.btnSubmit)

        btnKirim?.setOnClickListener(View.OnClickListener {

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            val store       = selectboxStore?.getSelectedItem().toString()
            val name        = inputName?.text.toString()

            editor.putString("store", store)
            editor.putString("name", name)
            editor.apply()

            val intent1 = Intent(this, LocationPage::class.java)
            startActivity(intent1)
        })
    }
}
