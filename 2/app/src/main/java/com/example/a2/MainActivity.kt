package com.example.a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radBtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Female)
        radGrp_Gender.setOnCheckedChangeListener{ _, checkedId ->
            var gender= when(checkedId){
                R.id.radBtn_Female -> radBtn_Female.text.toString()
                R.id.radBtn_Male -> radBtn_Male.text.toString()
                else ->"I don't Know"
            }
            Toast.makeText(this,gender,Toast.LENGTH_SHORT).show()
        }

    }


}