package com.example.alphabetbook

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutVertical = findViewById<LinearLayout>(R.id.linear_layout_vert)
        val row = 9
        val col = 3
        var buttonCount = 0


        for (i in 1..row) {
            val linearLayoutRow = LinearLayout(this)
            linearLayoutRow.orientation = LinearLayout.HORIZONTAL
            linearLayoutVertical.addView(linearLayoutRow)
            for (j in 1..col) {
                val button = Button(this)

                linearLayoutRow.addView(button)

                buttonCount++
                if (buttonCount == 26) break
            }
        }
    }
}