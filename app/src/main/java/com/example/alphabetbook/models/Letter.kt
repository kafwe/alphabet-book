package com.example.alphabetbook.models

import com.example.alphabetbook.Contract

class Letter(var imageNumber: Int = 1) : Contract.Model {
    override fun next() {
        imageNumber++
    }

    override fun prev() {
        imageNumber--
    }

    override fun first() {
        imageNumber = 1
    }

    override fun last() {
        imageNumber = 26
    }

    override fun getImageName(): String {
        return "slide$imageNumber"
    }

}