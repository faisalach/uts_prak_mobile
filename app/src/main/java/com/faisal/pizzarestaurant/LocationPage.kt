package com.faisal.pizzarestaurant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class LocationPage : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_page)

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        val titlebar = findViewById<TextView>(R.id.titlebar)
        titlebar.setText(getTitlebar())

        val storeTitle = findViewById<TextView>(R.id.storeTitle)
        storeTitle.setText(getStore())

        val btnKirim        = findViewById<Button>(R.id.btnSubmit)
        btnKirim?.setOnClickListener(View.OnClickListener {

            val intent1 = Intent(this, Menu::class.java)
            startActivity(intent1)
        })
    }

    private fun getTitlebar(): String? {
        val message     = sharedPreferences.getString("name", null)

        return "Hello, $message"
    }
    private fun getStore(): String? {
        val message     = sharedPreferences.getString("store", null)

        return message
    }
}
