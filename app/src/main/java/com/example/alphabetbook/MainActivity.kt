package com.example.alphabetbook

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.alphabetbook.MESSAGE"

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val lastActivity = sharedPreference.getString("activity", this.localClassName)

        if (lastActivity == "LetterActivity") {
            goToSavedLetter()
            return
        }

        setContentView(R.layout.activity_main)
        generateAlphabetButtons()
    }

    private fun generateAlphabetButtons() {
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

    private fun goToSavedLetter() {
        val imageNumber = sharedPreference.getInt("letter", 1)
        val intent = Intent(this, LetterActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, imageNumber)
        }
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        val editor = sharedPreference.edit()
        editor.putString("activity", this.localClassName)
        editor.apply()
    }

}