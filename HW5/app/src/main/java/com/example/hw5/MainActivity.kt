package com.example.hw5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val btnCompatActivity = findViewById<Button>(R.id.btnChangeActivity)
        val OpenBroser = findViewById<Button>(R.id.OpenBroser)
        val edtName = findViewById<TextView>(R.id.edtName)
        btnCompatActivity.setOnClickListener{
            var seconIntent = Intent(this,secondActivity::class.java)
            startActivity(seconIntent)
        }

        btnCompatActivity.setOnClickListener{
            var bundle = Bundle()
            var name = edtName.text.toString()
            bundle.putString("name",name)
            var secondIntent = Intent(this,secondActivity::class.java)
            secondIntent.putExtra("key",bundle)
            startActivity(secondIntent)
        }

        OpenBroser.setOnClickListener{
            var seconIntent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"))
            startActivity(seconIntent)
        }
    }
}