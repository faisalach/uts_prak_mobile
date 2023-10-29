package com.faisal.pizzarestaurant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Menu : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)


        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()


        data.add(ItemsViewModel(
            "Pepperoni Pizza" ,
            "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat",
            R.drawable.menu_pepperoni_pizza
        ))
        data.add(ItemsViewModel(
            "Spaghetti",
            "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental" ,
            R.drawable.menu_spaghetti
        ))
        data.add(ItemsViewModel(
            "Burger",
            "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal",
            R.drawable.menu_burger
        ))
        data.add(ItemsViewModel(
            "Steak",
            "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat",
            R.drawable.menu_steak
        ))


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        val titlebar = findViewById<TextView>(R.id.titlebar)
        titlebar.setText(getTitlebar())

    }
    private fun getTitlebar(): String? {
        val message     = sharedPreferences.getString("name", null)

        return "Hello, $message"
    }

    fun onCardClick(view: View) {
        val titleMenu   = view.findViewById<TextView>(R.id.titleItem).getText().toString();
        val descMenu   = view.findViewById<TextView>(R.id.descriptionItem).getText().toString();

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("menu_title", titleMenu)
        editor.putString("menu_desc", descMenu)
        editor.apply()

        val intent1 = Intent(this, DetailMenu::class.java)
        startActivity(intent1)
    }
}
