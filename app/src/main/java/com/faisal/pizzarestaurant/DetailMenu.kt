package com.faisal.pizzarestaurant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailMenu : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        val titleMenu = findViewById<TextView>(R.id.titleMenu)
        titleMenu.setText(getTitleMenu())

        val descriptionMenu = findViewById<TextView>(R.id.descriptionMenu)
        descriptionMenu.setText(getDescriptionMenu())

        val priceMenu = findViewById<TextView>(R.id.priceMenu)
        priceMenu.setText(getPriceMenu())

        val menuImage = findViewById<ImageView>(R.id.menuImage)
        menuImage.setImageResource(getMenuImage())


        val btnKirim        = findViewById<Button>(R.id.btnSubmit)
        btnKirim?.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(this, Order::class.java)
            startActivity(intent1)
        })

        val btnBack        = findViewById<Button>(R.id.btnBack)
        btnBack?.setOnClickListener(View.OnClickListener {
            val intent2 = Intent(this, Menu::class.java)
            startActivity(intent2)
        })
    }

    private fun getTitleMenu(): String? {
        val message     = sharedPreferences.getString("menu_title", null)
        return message
    }
    private fun getDescriptionMenu(): String? {
        val message     = sharedPreferences.getString("menu_desc", null)
        return message
        //return "Pepperoni pizza adalah pizza yang memiliki  topping daging pepperoni sapi asli. Di Italia, pepperoni disebut salame piccante (salami panas). Biasa menjadi bahan baku pizza di Amerika Serikat, yang sering mewakili 30% pelengkap. Pizza ini cocok untuk santap siang ataupun malam anda"
    }
    private fun getPriceMenu(): String? {
//        val message     = sharedPreferences.getString("name", null)
        return "Price: Rp 66.000,00"
    }

    private fun getMenuImage(): Int {
//        val message     = sharedPreferences.getString("name", null)
        return R.drawable.detail_menu_pizza
    }

}
