package com.example.hw5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val edtname = findViewById<TextView>(R.id.edtname)

        btnChangeActivity.setOnClickListener{
            val bundle = Bundle()
            val name = edtname.text.toString()
            bundle.putString("name",name)
            var seconIntent = Intent( this,Activity2::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

        btnOpenBrowser.setOnClickListener{
            var seconIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(seconIntent)
        }
    }
}