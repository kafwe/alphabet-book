package com.example.alphabetbook

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.alphabetbook.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutVertical = findViewById<LinearLayout>(R.id.linear_layout_vert)
        val row = 9
        val col = 3
        var buttonCount = 0
        var letter = 'A'


        for (i in 1..row) {
            val linearLayoutRow = LinearLayout(this)
            linearLayoutRow.orientation = LinearLayout.HORIZONTAL
            linearLayoutRow.gravity = Gravity.CENTER
            linearLayoutVertical.addView(linearLayoutRow)

            for (j in 1..col) {
                val letterButton = Button(this)

                with(letterButton) {
                    id = buttonCount + 1
                    text = letter.toString()
                    setOnClickListener {
                        val imageNumber = this.id
                        val intent = Intent(this@MainActivity, LetterActivity::class.java).apply {
                            putExtra(EXTRA_MESSAGE, imageNumber)
                        }
                        startActivity(intent)
                    }
                }

                linearLayoutRow.addView(letterButton)

                buttonCount++
                letter++
                if (buttonCount == 26) break
            }
        }
    }

}