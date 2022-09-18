package com.example.alphabetbook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DispatcherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreference = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val lastActivity = sharedPreference.getString("activity", this.localClassName)
        var intent: Intent? = null

        when (lastActivity) {
            "MainActivity" -> intent = Intent(this, MainActivity::class.java)

            "LetterActivity" -> {
                val imageNumber = sharedPreference.getInt("letter", 1)
                intent = Intent(this, LetterActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, imageNumber)
                }
            }
        }

        startActivity(intent!!)
    }
}