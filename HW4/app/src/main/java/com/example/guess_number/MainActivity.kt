package com.example.guess_number

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var txtCom: TextView
    private lateinit var txtResult: TextView
    private lateinit var Scissors: ImageButton
    private lateinit var Rock: ImageButton
    private lateinit var Paper: ImageButton
    private lateinit var imageView: ImageView // 修正了类型声明错误

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCom = findViewById(R.id.txtCom)
        txtResult = findViewById(R.id.txtResult)
        Scissors = findViewById(R.id.imbtnScissors)
        Rock = findViewById(R.id.imbtnRock)
        Paper = findViewById(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageView) // 确保 ID 正确

        //石頭
        Rock.setOnClickListener {
            playGame(Choice.ROCK)
        }
        //剪刀
        Scissors.setOnClickListener {
            playGame(Choice.SCISSORS)
        }
        //布
        Paper.setOnClickListener {
            playGame(Choice.PAPER)
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
                imageView.setImageResource(getChoiceDrawable(computerChoice)) // 使用函数获取图片资源
            }
            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.win)
                imageView.setImageResource(getChoiceDrawable(computerChoice)) // 使用函数获取图片资源
            }
            else -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
                imageView.setImageResource(getChoiceDrawable(computerChoice)) // 使用函数获取图片资源
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

    // 新增一个方法来根据选择获取对应的图片资源
    fun getChoiceDrawable(choice: Choice): Int {
        return when (choice) {
            Choice.SCISSORS -> R.drawable.scissor
            Choice.ROCK -> R.drawable.rock
            Choice.PAPER -> R.drawable.paper
        }
    }
}
