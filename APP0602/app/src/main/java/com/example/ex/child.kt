package com.example.ex

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex.databinding.ActivityChildBinding

class child : AppCompatActivity() {
    private lateinit var binding: ActivityChildBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChildBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_child)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var gender = ""

        binding.Numage.setMaxValue(18)
        binding.Numage.setMinValue(7)
        binding.Numage.setValue(12)

        binding.genderGR.setOnCheckedChangeListener { _, checkedId ->
            gender = when (checkedId) {
                R.id.M -> binding.M.text.toString()
                R.id.F -> binding.F.text.toString()
                else -> "I don't Know"
            }
        }

        binding.cback.setOnClickListener {
            finish()
        }

        binding.cSend.setOnClickListener {

            /* heigh */
            var bundle_heigh = Bundle()
            var heigh = binding.heigh.text.toString()
            bundle_heigh.putString("heigh", heigh)

            /* weigh */
            var bundle_weigh = Bundle()
            var weigh = binding.weigh.text.toString()
            bundle_weigh.putString("weigh", weigh)

            /* Gender */
            var bundle_Gender = Bundle()
            var Gender = gender.toString()
            bundle_Gender.putString("Gender", Gender)

            /* Age */
            var age = binding.Numage.getValue().toString().toInt()
            var bundle_Age = Bundle()
            var Age = binding.Numage.getValue().toString()
            bundle_Age.putString("Age", Age)

            /* Body heat */
            val body_heat = heat(age, gender)
            var bundle_body_heat = Bundle()
            var bodyheat = body_heat.toString()
            bundle_body_heat.putString("bodyheat", bodyheat)

            var chntent = Intent(this, ch_heat::class.java)
            chntent.putExtra("Key_heigh", bundle_heigh)
            chntent.putExtra("Key_weigh", bundle_weigh)
            chntent.putExtra("Key_Gender", bundle_Gender)
            chntent.putExtra("Key_Age",bundle_Age)
            chntent.putExtra("Key_heat",bundle_body_heat)
            startActivity(chntent)

        }



    }
    private fun heat(age: Int, gender: String): Int {
        return when (age) {
            in 7..10 -> when (gender) {
                binding.F.text.toString() -> 1740
                binding.M.text.toString() -> 1970
                else -> 0
            }
            in 11..14 -> when (gender) {
                binding.F.text.toString() -> 1845
                binding.M.text.toString() -> 2220
                else -> 0
            }
            in 15..18 -> when (gender) {
                binding.F.text.toString() -> 2110
                binding.M.text.toString() -> 2755
                else -> 0
            }
            else -> 0 // 增加了默认情况
        }
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
}