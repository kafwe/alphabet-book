package com.example.alphabetbook

interface Contract {
    interface View {
        fun nextLetter()
        fun prevLetter()
        fun firstLetter()
        fun lastLetter()
    }

    interface Model {
        fun next()
        fun prev()
        fun first()
        fun last()
        fun getImageName()
    }

    interface Presenter {
        fun nextLetter()
        fun prevLetter()
        fun firstLetter()
        fun lastLetter()
        fun goToLetterActivity()
    }
}