package com.example.hw5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val txttext = findViewById<TextView>(R.id.txttest)
        val btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)
        val text = intent.getBundleExtra("key")?.getString("name").toString()

        txttext.setText(text)
        btnBacktoFirst.setOnClickListener {
            finish()
        }

        }
        var lastTime: Long = 0
        override fun finish() {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastTime > 3 * 1000) {
                lastTime = currentTime
                Toast.makeText(this, "在按一下離開", Toast.LENGTH_SHORT).show()
            } else {
                super.finish()
            }
        }


    }
