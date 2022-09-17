package com.example.alphabetbook

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.example.alphabetbook.R

class ImageFactory {
    companion object {
        private val height = 369
        private val width = 426

        fun createBitmap(imageName: String, context: Context): Bitmap {
                val image = context.resources
                    .getIdentifier(imageName, "drawable", context.packageName)

                val futureTarget = Glide.with(context)
                    .asBitmap()
                    .load(image)
                    .submit(width, height)

                return futureTarget.get()

        }
    }
}