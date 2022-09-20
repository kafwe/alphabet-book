package com.example.alphabetbook.presenters

import android.content.Context
import com.example.alphabetbook.Contract
import com.example.alphabetbook.R
import com.example.alphabetbook.views.LetterActivity

/**
 * Class that contains the  core business logic.
 * It decides what to display and how to display it.
 * It triggers the View class to make the necessary
 * changes to the UI.
 *
 * @author Jordy Kafwe – KFWJOR001
 * @author Dylan Tasdhary - TSDDYL001
 */
class LetterPresenter(private var letterView: LetterActivity,
                      private val letterModel: Contract.Model) : Contract.Presenter {
    /**
     * Moves the state to the next letter and
     * updates the UI to reflect this change
     */
    override fun nextLetter() {
        letterModel.next()
        letterView.setImage(letterModel.imageName)
    }

    /**
     * Moves the state to the previous letter in the
     * alphabet and updates the UI to reflect this change
     */
    override fun prevLetter() {
        letterModel.prev()
        letterView.setImage(letterModel.imageName)
    }

    /**
     * Moves the state to the first letter (A) in the
     * alphabet and updates the UI to reflect this change
     */
    override fun firstLetter() {
        letterModel.first()
        letterView.setImage(letterModel.imageName)
    }

    /**
     * Moves the state to the last letter (Z) in the
     * alphabet and updates the UI to reflect this change
     */
    override fun lastLetter() {
        letterModel.last()
        letterView.setImage(letterModel.imageName)
    }


    /**
     * Saves that last activity the user was viewing before the
     * app is destroyed.
     */
    override fun saveState() {
        val sharedPreference = letterView.getSharedPreferences(
            letterView.getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val editor = sharedPreference.edit()
        editor.putString("activity", letterView.localClassName)

        editor.putInt("letter", letterModel.imageNumber)
        editor.apply()
    }

}