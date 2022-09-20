package com.example.alphabetbook.models

import com.example.alphabetbook.Contract

/**
 * Class that keeps track of which letter the app is currently on.
 *
 * @author Jordy Kafwe – KFWJOR001
 * @author Dylan Tasdhary - TSDDYL001
 */

class Letter(override var imageNumber: Int = 1) : Contract.Model {
    /**
     * Returns the name of the image for a specific letter
     *
     * @return the string representing the image name
     */
    override var imageName = "slide$imageNumber"

    /**
     * Moves to the next letter in the alphabet
     */
    override fun next() {
        imageNumber++
    }

    /**
     * Moves to the previous letter in the alphabet
     */
    override fun prev() {
        imageNumber--
    }

    /**
     * Moves to the first letter in the alphabet – or A.
     */
    override fun first() {
        imageNumber = 1
    }

    /**
     * Moves to the last letter in the alphabet – or Z.
     */
    override fun last() {
        imageNumber = 26
    }

}