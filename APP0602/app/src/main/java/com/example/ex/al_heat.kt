package com.example.ex

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex.databinding.ActivityAlHeatBinding

class al_heat : AppCompatActivity() {
    private lateinit var binding: ActivityAlHeatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAlHeatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_al_heat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* BMI */
        val al_BMI_text = intent.getBundleExtra("Key_Bmi")?.getString("Bmi").toString()
        binding.alBMI.setText("BMI:" + al_BMI_text)

        /* Gender */
        val Gender_text = intent.getBundleExtra("Key_Gender")?.getString("Gender").toString()
        binding.alGender.setText("Gender:" + Gender_text)

        /* pregnant */
        val pregnant_text = intent.getBundleExtra("Key_pregnant")?.getString("pregnant").toString()
        binding.alPregnant.setText("Pregnant:" + pregnant_text)

        /* Age */
        val Age_text = intent.getBundleExtra("Key_Age")?.getString("Age").toString()
        binding.alAGE.setText("Age:" + Age_text)

        /* jobtype */
        val jobtype_text = intent.getBundleExtra("Key_jobtype")?.getString("jobtype").toString()
        binding.alJobtype.setText("Jobtype:" + jobtype_text)

        /* type */
        val type_text = intent.getBundleExtra("Key_type")?.getString("type").toString()
        binding.alBodyType.setText("Bodytype:" + type_text)

        /* Heat */
        val bodyheat_text = intent.getBundleExtra("Key_heat")?.getString("bodyheat").toString()
        binding.alHeat.setText("Heat:" + bodyheat_text)

        binding.again.setOnClickListener {
            var againIntent = Intent(this,aldult::class.java)
            startActivity(againIntent)
        }
        binding.gomain.setOnClickListener {
            var gomainIntent = Intent(this,MainActivity::class.java)
            startActivity(gomainIntent)
        }



    }
}