package com.example.hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var btnBackofFirst = findViewById<Button>(R.id.btnBacktoFirst)
        var txttest = findViewById<TextView>(R.id.txttest)
        var text = intent.getBundleExtra("key")?.getString("name").toString()

        txttest.setText(text)

        btnBackofFirst.setOnClickListener {
            finish()
        }
    }
    var lastTime: Long = 0
    override fun finish() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastTime > 3 * 1000) {
            lastTime = currentTime
            Toast.makeText(this, "再按一下確認", Toast.LENGTH_SHORT).show()
        } else {
            super.finish()
        }
    }
}

