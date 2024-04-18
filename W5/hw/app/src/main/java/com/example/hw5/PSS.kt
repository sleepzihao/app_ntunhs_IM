package com.example.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class PSS : AppCompatActivity() {
    private lateinit var txtCom: TextView
    private lateinit var txtResult: TextView
    private lateinit var Scissors: ImageButton
    private lateinit var Rock: ImageButton
    private lateinit var Paper: ImageButton
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pss)
        val back = findViewById<Button>(R.id.btnback)
        txtCom = findViewById<TextView>(R.id.txtCom)
        txtResult = findViewById<TextView>(R.id.txtResult)
        Scissors = findViewById<ImageButton>(R.id.imbtnScissors)
        Rock = findViewById<ImageButton>(R.id.imbtnRock)
        Paper = findViewById<ImageButton>(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageview)

        //石頭
        Rock.setOnClickListener {
            val iComplay = Random().nextInt(3) + 1
            when (iComplay) {
                1 -> {
                    txtCom.setText(R.string.scissors)
                    txtResult.setText(getString(R.string.win))
                    imageView.setImageResource(R.drawable.scissor)
                }

                2 -> {
                    txtCom.setText(R.string.rock)
                    txtResult.setText(getString(R.string.draw))
                    imageView.setImageResource(R.drawable.rock)
                }

                3 -> {
                    txtCom.setText(R.string.paper)
                    txtResult.setText(getString(R.string.lose))
                    imageView.setImageResource(R.drawable.paper)
                }
            }
        }
        //剪刀
        Scissors.setOnClickListener {
            val iComplay = Random().nextInt(3) + 1
            when (iComplay) {
                1 -> {
                    txtCom.setText(R.string.scissors)
                    txtResult.setText(getString(R.string.draw))
                    imageView.setImageResource(R.drawable.scissor)
                }

                2 -> {
                    txtCom.setText(R.string.rock)
                    txtResult.setText(getString(R.string.lose))
                    imageView.setImageResource(R.drawable.rock)
                }

                3 -> {
                    txtCom.setText(R.string.paper)
                    txtResult.setText(getString(R.string.win))
                    imageView.setImageResource(R.drawable.paper)
                }
            }
        }
        //布
        Paper.setOnClickListener {

            val iComplay = Random().nextInt(3) + 1
            when (iComplay) {
                1 -> {
                    txtCom.setText(R.string.scissors)
                    txtResult.setText(getString(R.string.lose))
                    imageView.setImageResource(R.drawable.scissor)
                }

                2 -> {
                    txtCom.setText(R.string.rock)
                    txtResult.setText(getString(R.string.win))
                    imageView.setImageResource(R.drawable.rock)
                }

                3 -> {
                    txtCom.setText(R.string.paper)
                    txtResult.setText(getString(R.string.draw))
                    imageView.setImageResource(R.drawable.paper)
                }
            }
        }

        back.setOnClickListener {
            finish()
        }
    }

    enum class Choice {
        SCISSORS, ROCK, PAPER
    }

    fun playGame(playerChoice: Choice) {
        val choices = Choice.values()
        val computerChoice = choices[Random().nextInt(choices.size)]

        when {
            playerChoice == computerChoice -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.draw)
            }

            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.win)
            }

            else -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
            }
        }

    }

    fun getChoiceString(choice: Choice): Int {
        return when (choice) {
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
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
