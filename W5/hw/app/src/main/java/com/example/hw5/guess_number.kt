package com.example.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class guess_number : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_number)
        val textView = findViewById<TextView>(R.id.textView)
        val result_textView = findViewById<TextView>(R.id.result_textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        val back = findViewById<Button>(R.id.btnback)

        var secret: Int = Random.nextInt(10) + 1

        guess_button.setOnClickListener {
            val inputText = editText.text.toString()
            if (inputText.isNotEmpty()) {
                val validate_num: Int = inputText.toInt() - secret
                var ans_str: String = "恭喜!你猜對了!!!"
                if (validate_num > 0) {
                    ans_str = "你猜太大了!!"
                } else if (validate_num < 0) {
                    ans_str = "你猜小了，猜大一些~"
                }
                textView.text = ans_str
            } else {
                Toast.makeText(this, "請輸入數字", Toast.LENGTH_SHORT).show()
            }
        }

        reset_button.setOnClickListener {
            textView.text = "重新猜一個數字吧~"
        }
        back.setOnClickListener {
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