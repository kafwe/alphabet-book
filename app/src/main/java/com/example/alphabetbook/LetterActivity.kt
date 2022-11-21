package com.example.alphabetbook

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.alphabetbook.models.Letter
import com.example.alphabetbook.presenters.LetterPresenter


/**
 * Class that handles the user interface for the Letter page
 *
 * @author Jordy Kafwe
 */
class LetterActivity() : AppCompatActivity(), Contract.View {
    lateinit var presenter: LetterPresenter
    lateinit var imageView: ImageView
    lateinit var prevButton: Button
    lateinit var nextButton: Button
    lateinit var firstButton: Button
    lateinit var lastButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)

        val imageNumber = intent.getIntExtra(
            EXTRA_MESSAGE,
            1)
        val model = Letter(imageNumber)
        presenter = LetterPresenter(this, model)

        imageView = findViewById<ImageView>(R.id.imageView)
        prevButton = findViewById<Button>(R.id.prev_button)
        nextButton = findViewById<Button>(R.id.next_button)
        firstButton = findViewById<Button>(R.id.first_button)
        lastButton = findViewById<Button>(R.id.last_button)

        setNavigationButtonsState(model.imageNumber)
        setImage(model.imageName)
        setOnClickListeners()
    }


    /**
     * Updates the state (whether they are enabled or not) of
     * the navigation buttons based on the current
     * position in the alphabet.
     *
     * @param imageNumber the int representing the current position in the alphabet.
     */
    override fun setNavigationButtonsState(imageNumber: Int) {
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

    /**
     * Updates the image view UI component with the specified image.
     * This update happens in a background thread that does not block the current thread.
     *
     * @param imageName the name of the image
     */
    override fun setImage(imageName: String) {
        Thread(Runnable {
            val bitmap = ImageFactory.createBitmap(imageName, this)

            runOnUiThread(Runnable {
                imageView.setImageBitmap(bitmap)
            })
        }).start()
    }

    /**
     * Sets the onClickListeners for all the
     * navigation buttons in the view
     */
    private fun setOnClickListeners() {
        firstButton.setOnClickListener {
            presenter.firstLetter()
        }

        prevButton.setOnClickListener {
            presenter.prevLetter()
        }

        nextButton.setOnClickListener {
            presenter.nextLetter()
        }

        lastButton.setOnClickListener {
            presenter.lastLetter()
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.saveState()
    }

}