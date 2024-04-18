package com.example.hw3

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applyDate = findViewById<EditText>(R.id.applydate)
        applyDate.setOnClickListener{
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month =calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,{ _, year, month, day ->
                run {
                    val format = "${setDateFormat(year, month, day)}"
                    applyDate.setText(format)
                }
            }, year, month, day).show()

        }

        val chkbox1 = findViewById<CheckBox>(R.id.checkBox)
        val chkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val chkbox3 = findViewById<CheckBox>(R.id.checkBox3)

        val btn_send =findViewById<Button>(R.id.Send)

        btn_send.setOnClickListener{
            var  msg=""
            if(chkbox1.isChecked()){
                msg=msg + chkbox1.getText().toString()
            }
            if(chkbox2.isChecked()){
                msg = msg + "、" + chkbox2.getText().toString()
            }
            if(chkbox3.isChecked()){
                msg = msg + "、" + chkbox3.getText().toString()
            }
            Toast.makeText( this@MainActivity, "你選的是" + msg,
                Toast.LENGTH_SHORT).show()
        }


    }

}

private fun  setDateFormat(year: Int, month: Int, day: Int): String{
    return  "$year-${month + 1}-$day"}