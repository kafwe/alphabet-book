package com.example.alphabetbook

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.createBitmap


class LetterActivity() : AppCompatActivity() {
    var imageNumber: Int = -1
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)
        imageView = findViewById<ImageView>(R.id.imageView)
        prevButton = findViewById<Button>(R.id.prev_button)
        nextButton = findViewById<Button>(R.id.next_button)
        imageNumber = intent.getIntExtra(EXTRA_MESSAGE,
            1)
        setNavigationButtonsState()
        setImage()
    }

    fun setNavigationButtonsState() {
        when (imageNumber) {
            1 -> {
                prevButton.isEnabled = false
                nextButton.isEnabled = true
            }

            26 -> {
                prevButton.isEnabled = true
                nextButton.isEnabled = false
            }

            else -> {
                prevButton.isEnabled = true
                nextButton.isEnabled = true
            }
        }
    }

    private fun setImage() {
        val imageName = "slide$imageNumber"
        Thread(Runnable {
            val bitmap = ImageFactory.createBitmap(imageName, this)

            runOnUiThread(Runnable {
                imageView.setImageBitmap(bitmap)
            })
        }).start()
    }

    fun first(view: View) {
        imageNumber = 1
        setNavigationButtonsState()
        setImage()
    }

    fun last(view: View) {
        imageNumber = 26
        setNavigationButtonsState()
        setImage()
    }

    fun prev(view: View) {
        imageNumber--
        setNavigationButtonsState()
        setImage()
    }

    fun next(view: View) {
        imageNumber++
        setNavigationButtonsState()
        setImage()
    }

}