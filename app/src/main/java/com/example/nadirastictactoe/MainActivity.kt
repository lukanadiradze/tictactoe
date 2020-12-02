package com.example.nadirastictactoe

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var restartbutton: Button


    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        Restart()

    }

    private fun init() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        restartbutton = findViewById(R.id.restartbutton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        restartbutton.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView)
            }
        }

    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setTextColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text = "O"
            clickedView.setTextColor(Color.BLUE)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check() {
        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "O wins!", Toast.LENGTH_LONG).show()
            }
            disableButtons()
        }
    }
    private fun disableButtons(){
    button1.isEnabled = false
    button2.isEnabled = false
    button3.isEnabled = false
    button4.isEnabled = false
    button5.isEnabled = false
    button6.isEnabled = false
    button7.isEnabled = false
    button8.isEnabled = false
    button9.isEnabled = false

  }

    fun Restart() {

        restartbutton.setOnClickListener {

            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true

            firstPlayer.clear()
            secondPlayer.clear()
            activePlayer = 1

            button1.setBackgroundColor(Color.parseColor("#17403E3E"))
            button2.setBackgroundColor(Color.parseColor("#17403E3E"))
            button3.setBackgroundColor(Color.parseColor("#17403E3E"))
            button4.setBackgroundColor(Color.parseColor("#17403E3E"))
            button5.setBackgroundColor(Color.parseColor("#17403E3E"))
            button6.setBackgroundColor(Color.parseColor("#17403E3E"))
            button7.setBackgroundColor(Color.parseColor("#17403E3E"))
            button8.setBackgroundColor(Color.parseColor("#17403E3E"))
            button9.setBackgroundColor(Color.parseColor("#17403E3E"))
            button1.setTextColor((Color.parseColor("#17403E3E")))
            button2.setTextColor((Color.parseColor("#17403E3E")))
            button3.setTextColor((Color.parseColor("#17403E3E")))
            button4.setTextColor((Color.parseColor("#17403E3E")))
            button5.setTextColor((Color.parseColor("#17403E3E")))
            button6.setTextColor((Color.parseColor("#17403E3E")))
            button7.setTextColor((Color.parseColor("#17403E3E")))
            button8.setTextColor((Color.parseColor("#17403E3E")))
            button9.setTextColor((Color.parseColor("#17403E3E")))



        }

    }
}

