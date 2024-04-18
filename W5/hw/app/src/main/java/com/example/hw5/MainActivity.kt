package com.example.hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guess = findViewById<Button>(R.id.guess)
        val pss = findViewById<Button>(R.id.btnpss)

        guess.setOnClickListener{
            val guessIntent = Intent(this,guess_number::class.java)
            startActivity(guessIntent)
        }

        pss.setOnClickListener{
            val pssIntent = Intent(this,PSS::class.java)
            startActivity(pssIntent)
        }

    }
}