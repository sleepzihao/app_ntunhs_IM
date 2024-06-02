package com.example.ex

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex.databinding.ActivityAldultBinding
import com.example.ex.databinding.ActivityMainBinding
import kotlin.math.sqrt

class aldult : AppCompatActivity() {
    private lateinit var binding: ActivityAldultBinding
    private var pregnant = ""
    private var bmi :Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAldultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_aldult)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var gender = ""
        var jobtype = ""
        var work :Int


        binding.Numage.setMaxValue(80)
        binding.Numage.setMinValue(19)
        binding.Numage.setValue(25)
        setRG(false)

        binding.jobtypeGR.setOnCheckedChangeListener { _, checkedId ->
            jobtype = when(checkedId){
                R.id.Mild -> binding.Mild.text.toString()
                R.id.Moderate -> binding.Moderate.text.toString()
                R.id.Severe -> binding.Severe.text.toString()
                else -> "I don't Know"
            }
        }

        binding.genderGR.setOnCheckedChangeListener { _, checkedId ->
            gender = when(checkedId){
                R.id.M -> binding.M.text.toString()
                R.id.F -> binding.F.text.toString()
                else -> "I don't Know"
            }
            if (checkedId == R.id.F){
                setRG(true)
            }else{
                setRG(false)
            }
        }
        binding.Send.setOnClickListener {
            /* bmi */
            val we :Double = binding.inweight.text.toString().toDouble()
            val he :Double = binding.inheight.text.toString().toDouble()/100
            bmi = BMI(we,he)
            var bundle_Bmi = Bundle()
            var Bmi = String.format("%.1f", Math.floor(bmi * 10) / 10)
            bundle_Bmi.putString("Bmi", Bmi)

            /* Gender */
            var bundle_Gender = Bundle()
            var Gender = gender.toString()
            bundle_Gender.putString("Gender", Gender)

            /* pregnant */
            var bundle_pregnant = Bundle()
            var pregnant = pregnant.toString()
            bundle_pregnant.putString("pregnant", pregnant)

            /* Age */
            var bundle_Age = Bundle()
            var Age = binding.Numage.getValue().toString()
            bundle_Age.putString("Age", Age)

            /* jobtype */
            var bundle_jobtype = Bundle()
            var Jobtype = jobtype.toString()
            bundle_jobtype.putString("jobtype", Jobtype)

            /* Body type */
            var type = ""
            if(bmi < 18.5){
                type = "Too Mild"
            }
            if(bmi >= 18.5 || bmi < 24){
                type = "Normal"
            }
            if (bmi >=24){
                type = "Too heavy"
            }
            var bundle_type = Bundle()
            var Type = type.toString()
            bundle_type.putString("type", Type)

            /* Body heat */
            val body_heat = heat(jobtype,bmi,we)
            var bundle_body_heat = Bundle()
            var bodyheat = body_heat.toString()
            bundle_body_heat.putString("bodyheat", bodyheat)

            var alntent = Intent(this,al_heat::class.java)
            alntent.putExtra("Key_Bmi",bundle_Bmi)
            alntent.putExtra("Key_Gender",bundle_Gender)
            alntent.putExtra("Key_pregnant",bundle_pregnant)
            alntent.putExtra("Key_Age",bundle_Age)
            alntent.putExtra("Key_jobtype",bundle_jobtype)
            alntent.putExtra("Key_type",bundle_type)
            alntent.putExtra("Key_heat",bundle_body_heat)
            startActivity(alntent)
        }

        binding.aback.setOnClickListener {
            finish()
        }

    }
    fun BMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
    private fun heat(jobType: String, bmi: Double, weight: Double): Int {
        var BH = when {
            bmi < 18.5 -> when (jobType) {
                binding.Mild.text.toString() -> (35 * weight).toInt()
                binding.Moderate.text.toString() -> (40 * weight).toInt()
                binding.Severe.text.toString() -> (45 * weight).toInt()
                else -> 0
            }
            bmi in 18.5..23.9 -> when (jobType) {
                binding.Mild.text.toString() -> (30 * weight).toInt()
                binding.Moderate.text.toString() -> (35 * weight).toInt()
                binding.Severe.text.toString() -> (40 * weight).toInt()
                else -> 0
            }
            else -> when (jobType) {
                binding.Mild.text.toString() -> (20 * weight).toInt()
                binding.Moderate.text.toString() -> (30 * weight).toInt()
                binding.Severe.text.toString() -> (35 * weight).toInt()
                else -> 0
            }
        }

        BH += when (pregnant) {
            binding.Secondtrimester.text.toString() -> 285
            binding.Thirdtrimester.text.toString() -> 475
            else -> 0
        }

        return BH
    }


    var lasttime: Long = 0
    override fun finish() {
        val currentTime = System.currentTimeMillis()
        if(currentTime - lasttime > 3 * 1000){
            lasttime = currentTime
            Toast.makeText(this,"aging", Toast.LENGTH_SHORT).show()
        } else {
            super.finish()
        }
    }
    private fun setRG(isEnabled: Boolean){
        binding.notpregnant.isEnabled = isEnabled
        binding.Secondtrimester.isEnabled = isEnabled
        binding.Thirdtrimester.isEnabled = isEnabled
        binding.pregnantRG.setOnCheckedChangeListener { _, checkedId ->
            pregnant  = when(checkedId){
               R.id.notpregnant -> binding.notpregnant.text.toString()
               R.id.Secondtrimester -> binding.Secondtrimester.text.toString()
               R.id.Thirdtrimester -> binding.Thirdtrimester.text.toString()
               else -> "I don't Know"
           }
       }
    }
}