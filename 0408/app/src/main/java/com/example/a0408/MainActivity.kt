package com.example.a0408

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

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
        val genderG = findViewById<RadioGroup>(R.id.genderG)
        val M = findViewById<RadioButton>(R.id.butm)
        val F = findViewById<RadioButton>(R.id.butf)
        val edid = findViewById<EditText>(R.id.inID)
        val edqwp = findViewById<EditText>(R.id.inpwd)
        val edname = findViewById<EditText>(R.id.inname)
        val edbirthdate = findViewById<EditText>(R.id.inbirthdate)
        val Car = findViewById<CheckBox>(R.id.chcar)
        val Bike = findViewById<CheckBox>(R.id.chbike)
        val Motorbike = findViewById<CheckBox>(R.id.chmotorbike)
        var gender_G = ""
        var msg =""

        genderG.setOnCheckedChangeListener { _, checkedId ->
            gender_G = when(checkedId){
                R.id.butf -> F.text.toString()
                R.id.butm -> M.text.toString()
                else -> "I don't Know"


            }
}
        val inDate = findViewById<EditText>(R.id.inbirthdate)
        inDate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,{ _,year, month, day ->
                run {
                    var format = "${setDate(year, month, day)}"
                    inDate.setText(format)
                }
            }, year, month, day).show()
        }
        val Send = findViewById<Button>(R.id.btnSend)
        Send.setOnClickListener {
            /* ID */
            var bundle_id = Bundle()
            var id = edid.text.toString()
            bundle_id.putString("id", id)

            /* pwd */
            var bundle_pwd = Bundle()
            var pwd = edqwp.text.toString()
            bundle_pwd.putString("pwd", pwd)

            /* name */
            var bundle_name = Bundle()
            var name = edname.text.toString()
            bundle_name.putString("name", name)

            /* birthdate */
            var bundle_birthdate = Bundle()
            var birthdate = edbirthdate.text.toString()
            bundle_birthdate.putString("birthdate", birthdate)

            /* gender */
            var bundle_gender = Bundle()
            var gender = gender_G
            bundle_gender.putString("gender", gender)

            /* vehide */
            msg = ""
            if (Car.isChecked){
                msg = msg + Car.getText().toString()
            }
            if (Bike.isChecked && Car.isChecked){
                msg = msg +"," + Bike.getText().toString()
            }else if (Bike.isChecked){
                msg = msg + Bike.getText().toString()
            }
            if (Motorbike.isChecked && Bike.isChecked){
                msg = msg +"," + Motorbike.getText().toString()
            }else if (Motorbike.isChecked && Car.isChecked){
                msg = msg +"," + Motorbike.getText().toString()
            }else if (Motorbike.isChecked){
                msg = msg + Motorbike.getText().toString()
            }

            var bundle_vehide = Bundle()
            var vehide = msg
            bundle_vehide.putString("vehide", vehide)

            var resultIntent = Intent(this,result::class.java)
            resultIntent.putExtra("key_id",bundle_id)
            resultIntent.putExtra("key_pwd",bundle_pwd)
            resultIntent.putExtra("key_name",bundle_name)
            resultIntent.putExtra("key_birthdate",bundle_birthdate)
            resultIntent.putExtra("key_gender",bundle_gender)
            resultIntent.putExtra("key_vehide",bundle_vehide)
            startActivity(resultIntent)
        }
    }
    private fun setDate(year: Int, month: Int, day: Int):String {
        return "$year - ${month + 1} - $day"
    }
}
