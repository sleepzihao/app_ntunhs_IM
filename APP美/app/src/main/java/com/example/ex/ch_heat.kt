package com.example.ex

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex.databinding.ActivityChHeatBinding

class ch_heat : AppCompatActivity() {
    private lateinit var binding: ActivityChHeatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChHeatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_ch_heat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* heigh */
        val heigh_text = intent.getBundleExtra("Key_heigh")?.getString("heigh").toString()
        binding.chHeigh.setText("heigh:" + heigh_text)

        /* weigh */
        val weigh_text = intent.getBundleExtra("Key_weigh")?.getString("weigh").toString()
        binding.chWeigh.setText("weigh:" + weigh_text)

        /* Gender */
        val Gender_text = intent.getBundleExtra("Key_Gender")?.getString("Gender").toString()
        binding.chGender.setText("Gender:" + Gender_text)

        /* Age */
        val Age_text = intent.getBundleExtra("Key_Age")?.getString("Age").toString()
        binding.chAge.setText("Age:" + Age_text)

        /* Heat */
        val bodyheat_text = intent.getBundleExtra("Key_heat")?.getString("bodyheat").toString()
        binding.chHeat.setText("Heat:" + bodyheat_text)




        binding.again.setOnClickListener {
            var againIntent = Intent(this,child::class.java)
            startActivity(againIntent)
        }
        binding.gomain.setOnClickListener {
            var gomainIntent = Intent(this,MainActivity::class.java)
            startActivity(gomainIntent)
        }
    }
}