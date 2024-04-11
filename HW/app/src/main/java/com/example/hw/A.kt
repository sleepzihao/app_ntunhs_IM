package com.example.hw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class A : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.button2)



        btnBack.setOnClickListener{
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }



        }
    }
