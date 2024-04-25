package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.guess_number.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout.TabGravity
import kotlin.random.Random
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private lateinit var binding: ActivityMainBinding
    private val game = GuessingGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        binding.guessButton.setOnClickListener {
            val guessNum = binding.editText.text.toString().toInt()
            val resultText = game.guessNumber(guessNum)
            binding.textView.text = game.getRangeText()
            binding.resultTextView.text = resultText
            if (resultText == "猜對了") {
                handler.postDelayed({
                    Toast.makeText(this, "六秒後重置", Toast.LENGTH_SHORT).show()
                    game.resetGame()
                    binding.resultTextView.text = "再猜一次"
                    binding.textView.text = "下一回合"
                }, 6000)
            }
        }

        binding.resetButton.setOnClickListener {
            game.resetGame()
            binding.resultTextView.text = "再猜一次"

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}