package com.example.hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.button)

            btnChangeActivity.setOnClickListener{
                var seconIntent = Intent(this,A::class.java)
                startActivity(seconIntent)
            }

        

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val adapter2 = ArrayAdapter.createFromResource(this,R.array.spinner2,android.R.layout.simple_spinner_dropdown_item)

        spinner2.adapter = adapter2


    }
}