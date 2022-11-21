package com.example.alphabetbook

import android.view.View

interface Contract {
    interface View {
        fun setNavigationButtonsState(imageNumber: Int)
        fun setImage(imageName: String)
    }

    interface Model {
        val imageName: String
        var imageNumber: Int
        fun next()
        fun prev()
        fun first()
        fun last()
    }

    interface Presenter {
        fun nextLetter()
        fun prevLetter()
        fun firstLetter()
        fun lastLetter()
        fun saveState()
    }
}