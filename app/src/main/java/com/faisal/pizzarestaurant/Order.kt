package com.faisal.pizzarestaurant

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Order : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        val textOrderDetailDesc = findViewById<TextView>(R.id.textOrderDetailDesc)
        textOrderDetailDesc.setText(getTextOrderDetailDesc())

        val btnKirim        = findViewById<Button>(R.id.btnSubmit)
        btnKirim?.setOnClickListener(View.OnClickListener {
            displayToast(message())
        })
    }

    private fun message(): String? {
        val name            = sharedPreferences.getString("name", null)

        val radioGroup      = findViewById<RadioGroup>(R.id.radioGroup1)
        val selectedId      = radioGroup.getCheckedRadioButtonId()

        // find the radiobutton by returned id
        val radioButton     = findViewById<RadioButton>(selectedId)
        val pengiriman      = radioButton.getText()

        //val menu            = "Pepperoni Pizza"
        val menu            = sharedPreferences.getString("menu_title", null)


        return "Terima kasih Pa $name sudah memesan \n" +
                "ditoko kami, pesanan $menu \n" +
                "anda dikirim menggunakan $pengiriman"
    }

    private fun getTextOrderDetailDesc(): String? {
        val name            = sharedPreferences.getString("name", null)
        val store           = sharedPreferences.getString("store", null)
        //val menu            = "Pepperoni Pizza"
        val menu            = sharedPreferences.getString("menu_title", null)
        return "$name \n"+
                "Store : $store \n" +
                "$menu sudah dipesan"

    }

    fun displayToast(message: String?) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show()
    }
}
